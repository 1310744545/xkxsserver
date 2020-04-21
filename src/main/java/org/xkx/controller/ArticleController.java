package org.xkx.controller;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xkx.pojo.article;
import org.xkx.pojo.articleImg;
import org.xkx.service.IArticleImgServer;
import org.xkx.service.IArticleService;
import org.xkx.service.IGodService;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    IGodService iGodService;
    @Autowired
    IArticleService iArticleService;
    @Autowired
    IArticleImgServer iArticleImgServer;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addArticleImg")
    public String addArticalImg(@RequestParam("file")MultipartFile file){
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "www.xkxxkx.cn");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "qq10086..");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");

        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return "系统错误,上传失败";
        }
        int uid= iArticleService.selectMax()+1;
        String dst = "/opt/apache-tomcat-9.0.33/webapps/article/"+uid+"的"+file.getOriginalFilename(); // 目标文件名
        String url="http://www.xkxxkx.cn:8080/article/"+uid+"的"+file.getOriginalFilename();
        SFTPChannel channel = new SFTPChannel();
        try {
            ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
            chSftp.put(inputStream, dst, ChannelSftp.OVERWRITE);
            iArticleImgServer.addImg(new articleImg(url,uid));
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return url;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addArticle")
    public String addArtical(@RequestBody article article){
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "www.xkxxkx.cn");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "root");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "qq10086..");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");
        SFTPChannel channel = new SFTPChannel();
        ChannelSftp chSftp = null;


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        String dateStr = sdf.format(date);
        int uid= iArticleService.selectMax()+1;
        List <String> urlList=iArticleImgServer.selectImgByUid(uid);

        for (String url :urlList){
            if (article.getContent().indexOf(url)==-1){
                String trueurl=url.substring(34);
                iArticleImgServer.deleteUrl(url);
                try{
                    chSftp = channel.getChannel(sftpDetails, 60000);
                    chSftp.rm("/opt/apache-tomcat-9.0.33/webapps/article/"+trueurl);
                }catch (SftpException e){
                    return "失败,系统错误";
                } catch (JSchException e) {
                    return "失败,系统错误";
                }
            }
        }
        org.xkx.pojo.article newarticle = new article(uid, article.getTitle(), article.getContent(), article.getUid(), dateStr);
        iArticleService.addArticle(newarticle);
        return "成功";
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/selectArticle")
    public List<article> selectArticle(@RequestBody article article){
        List<org.xkx.pojo.article> articles = iArticleService.selectArticle(article.getUid());
        return articles;
    }
}
