package com.zzkk.soccer_video.controller;

import com.zzkk.soccer_video.mapper.VideoUploadMapper;
import com.zzkk.soccer_video.pojo.VideoUpload;
import com.zzkk.soccer_video.service.SseEmitterServer;
import com.zzkk.soccer_video.service.detectionServer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

/**
 * @ClassName sseController
 * @Description
 * @date 2023/2/24 19:22
 * @Version 1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sse")
@Slf4j
@AllArgsConstructor
public class sseController {
    VideoUploadMapper videoUploadMapper;

    private static final Logger logger = LoggerFactory.getLogger(SseEmitterServer.class);
    /**
     * 用于创建连接（将用户注册到server中）
     */
    /**
     * 用于创建连接
     */
    @GetMapping("/connect/{video_id}")
    public SseEmitter connect(@PathVariable String video_id) {
        System.out.println(222);
        return  SseEmitterServer.connect(video_id);
    }

    @GetMapping("/start/{video_id}")
    public void detectionStart(@PathVariable(name = "video_id") Integer video_id) {
        VideoUpload onevideo = videoUploadMapper.SelectVideoId(video_id);
        String videoPath = onevideo.getVideoPath();
//        System.out.println();
        detectionServer.runDetection(video_id.toString(), videoPath);
    }



//    @GetMapping("/eventDetection/{videoPath}")
//    public ResponseEntity<String> eventDetection(@PathVariable(name = "message") String message) {
////        SseEmitterServer.batchSendMessage(message);
////        return ResponseEntity.ok("WebSocket 推送消息给所有人");
//
//
//    }
}
