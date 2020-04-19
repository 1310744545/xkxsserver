package org.xkx.controller;


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "129.211.56.158");
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
        } catch (JSchException e) {
            e.printStackTrace();
            return new Result("系统错误,上传失败");
        } catch (SftpException e) {
            e.printStackTrace();
            return new Result("系统错误,上传失败");
        }
        String headImg="http://129.211.56.158:8080/upload/"+headid+"的"+k+file.getOriginalFilename();
        Map<Object, Object> headMap = new HashMap<>();
        headMap.put("id",headid);
        headMap.put("headImg",headImg);
        iGodService.setHeadUrl(headMap);
        return new Result("上传成功");

    }

}
