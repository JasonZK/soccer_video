package com.zzkk.soccer_video.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName VideoUpload
 * @Description
 * @date 2022/12/21 14:51
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoUpload {
    private int videoId;
    private String videoName;
    private String videoUrl;
    private String videoUUID;
    private String videoSize;
    private String createdTime;
    private String videoPath;
}
