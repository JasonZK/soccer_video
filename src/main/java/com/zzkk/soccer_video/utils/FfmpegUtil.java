package com.zzkk.soccer_video.utils;

import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FfmpegUtil
 * @Description
 * @date 2023/1/30 15:47
 * @Version 1.0
 */
@Component
public class FfmpegUtil {
    public static void videoMp4ConvertToH264(String ffmpegPath, String videoInputPath, String videoOutputPath) throws IOException {
        // 构建命令
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(videoInputPath);
        command.add("-vcodec");
        command.add("h264");
        command.add(videoOutputPath);
        command.forEach(v -> System.out.print(v + " "));
        System.out.println();
        System.out.println();
        // 执行操作
        ProcessBuilder builder = new ProcessBuilder();
        //正常信息和错误信息合并输出
        builder.redirectErrorStream(true);
        builder.command(command);

        try {
            Process process = builder.start();
            System.out.println("converting from *" + videoInputPath + "* to *" + videoOutputPath + "*");
            //如果你想获取到执行完后的信息，那么下面的代码也是需要的
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
