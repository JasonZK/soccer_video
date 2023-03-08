package com.zzkk.soccer_video.controller;

import com.zzkk.soccer_video.mapper.VideoUploadMapper;
import com.zzkk.soccer_video.pojo.VideoUpload;
import com.zzkk.soccer_video.utils.NonStaticResourceHttpRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @ClassName SelectVideoController
 * @Description
 * @date 2022/12/21 14:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/SelectVideo")
@AllArgsConstructor
public class SelectVideoController {

    private final NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @Autowired
    VideoUploadMapper videoUploadMapper;

    //解决跨域的注解
    @CrossOrigin(origins = "*", maxAge = 3600)
    //查询视频流的接口
    @GetMapping("/all/{videoId}")
    //前两个参数不管，第三个参数videoId代表前端传过来的视频的id号
    public void videoPreview(HttpServletRequest request, HttpServletResponse response, @PathVariable("videoId") Integer videoId) throws Exception {
        //调用查询方法，把前端传来的id传过去，查询对应的视频信息。
        VideoUpload videoPathList = videoUploadMapper.SelectVideoId(videoId);
        //从视频信息中单独把视频路径信息拿出来保存
        String videoPathUrl=videoPathList.getVideoUrl();
        //保存视频磁盘路径
        Path filePath = Paths.get(videoPathUrl );
        //Files.exists：用来测试路径文件是否存在
        if (Files.exists(filePath)) {
            //获取视频的类型，比如是MP4这样
            String mimeType = Files.probeContentType(filePath);
            if (StringUtils.hasText(mimeType)) {
                //判断类型，根据不同的类型文件来处理对应的数据
                response.setContentType(mimeType);
            }
            //转换视频流部分
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/selectById/{videoId}")
    public VideoUpload getById(@PathVariable(name = "videoId") Integer videoId)
    {
        System.out.println("here");
        VideoUpload res = videoUploadMapper.SelectVideoId(videoId);
        System.out.println(res);
        return res;
    }

    //查询视频表格列表的接口
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/table")
    public List<VideoUpload> videoTable() {
        //调用搜索方法查询所有视频信息，成表格展示前端
        List<VideoUpload> res = videoUploadMapper.SelectVideoAll();
        System.out.println(res);
        return res;
    }


}
