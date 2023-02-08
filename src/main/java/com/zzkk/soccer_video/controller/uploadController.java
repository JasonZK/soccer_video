package com.zzkk.soccer_video.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @ClassName uploadController
 * @Description
 * @date 2022/12/11 14:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/upload")
@Slf4j
public class uploadController {

    @RequestMapping("/toUpload")
    public String toUpload()
    {
        return "test1";
    }

    @RequestMapping("/saveVideoAddress")
    @ResponseBody
    public ModelMap saveVideoAddress(MultipartFile videoFileAddress,
                                     HttpServletRequest request, HttpServletResponse response) {
        ModelMap map = new ModelMap();
        String paFileName = videoFileAddress.getOriginalFilename();

        String saveFilePath = "D://study//proj//soccer//upload_video";

        if (videoFileAddress != null &&paFileName != null && paFileName.length() > 0) {
            //try {
            //FtpUtil ftpUtil = new FtpUtil();
            //FTPClient ftp = ftpUtil.getConnectionFTP(UploadFileUrlUtil.HOST_NAEM, UploadFileUrlUtil.PORT,UploadFileUrlUtil.USER_NAME, UploadFileUrlUtil.PASSWORD);
            //String filename = FtpUtil.getFileName(videoFileAddress);
            //boolean bool = ftpUtil.uploadFile(ftp,UploadFileUrlUtil.GetPath(UploadFileUrlUtil.VIDEO_PATH) , filename,videoFileAddress.getInputStream());
            // if (bool) {
            //String url = saveFilePath  + paFileName;
            //map.put("videoAddress", url);
            // map.put("videoName", paFileName);
            //System.out.println("上传成功！");
            // boolean boolClose = ftpUtil.closeFTP(ftp);
            //if (boolClose) {
            //  System.out.println("关闭ftp连接成功！");
            //} else {
            // System.out.println("关闭ftp连接失败！");
            //}

            File newFile = new File(saveFilePath + "\\" + paFileName);
            //newFile。
            // 将内存中的数据写入磁盘
            try {
                videoFileAddress.transferTo(newFile);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 将新图片名称返回到前端
            //Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "成功啦");
            map.put("url", paFileName);
            //return map;
        } else {
            System.out.println("上传失败！");
        }
        return map;

        //} catch (Exception e1) {
        // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }
        //return ReturnUtil.Success("加载成功", map, null);
    }

}
