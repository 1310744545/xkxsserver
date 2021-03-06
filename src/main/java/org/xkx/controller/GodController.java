package org.xkx.controller;


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xkx.pojo.god;
import org.xkx.service.IGodService;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class GodController {

    @Autowired
    IGodService iGodService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("God")
    public god GodNameById(@RequestBody god god){
        return iGodService.selectGodById(god.getId());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("GodUpdate")
    public String godUpdateById(@RequestBody god god){
        return iGodService.godUpdateById(god);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/headImg")
    public Result headImg(@RequestParam("img") MultipartFile file,@RequestParam("headid") int headid){
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
            return new Result("系统错误,上传失败");
        }
        Random random = new Random();
        int k = random.nextInt();
        String dst = "/opt/apache-tomcat-9.0.33/webapps/upload/"+headid+"的"+k+file.getOriginalFilename(); // 目标文件名
        SFTPChannel channel = new SFTPChannel();
        try {
            ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
            chSftp.put(inputStream, dst, ChannelSftp.OVERWRITE);
            String substring = iGodService.selectGodById(headid).getHeadImg().substring(33);
            if(!substring.equals("a6beec64369c2642b92c6726f1epng.png")){
                chSftp.rm("/opt/apache-tomcat-9.0.33/webapps/upload/"+substring);
            }
        } catch (JSchException e) {
            e.printStackTrace();
            return new Result("系统错误,上传失败");
        } catch (SftpException e) {
            e.printStackTrace();
            return new Result("系统错误,上传失败");
        }
        String headImg="http://www.xkxxkx.cn:8080/upload/"+headid+"的"+k+file.getOriginalFilename();
        Map<Object, Object> headMap = new HashMap<>();
        headMap.put("id",headid);
        headMap.put("headImg",headImg);
        iGodService.setHeadUrl(headMap);
        return new Result("上传成功");
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/qqLogin")
    public god GodNameById(@RequestBody Map<String,String> map){
        if(iGodService.isExist(map.get("openId"))){
            //存在
            return iGodService.selectGodByCount(map.get("openId"));
        }else {
            //不存在
            god God=new god();
            God.setCount(map.get("openId"));
            God.setPassword("null");
            God.setName(map.get("name"));
            God.setUrl("空空如也");
            God.setIntroduction("空空如也");
            God.setHeadImg(map.get("imgUrl"));
            iGodService.addGod(God);
            return God;
        }
    }
}
