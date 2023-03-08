package com.zzkk.soccer_video.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ClassName detectionServer
 * @Description
 * @date 2023/2/25 19:57
 * @Version 1.0
 */
@Service
public class detectionServer {
    public static void runDetection(String videoId, String videoPath){
        //定义个获取结果的变量
        StringBuilder result= new StringBuilder();

        try {
            //调用python，其中字符串数组对应的是python，python文件路径，向python传递的参数
            String[] strs=new String[] {"D:\\software\\Anaconda3\\envs\\py37\\python.exe","D:\\study\\proj\\soccer\\graduate_soccer_caption_event_detection\\goal_detection_for_one_video.py", videoPath};
            //Runtime类封装了运行时的环境。每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。
            //一般不能实例化一个Runtime对象，应用程序也不能创建自己的 Runtime 类实例，但可以通过 getRuntime 方法获取当前Runtime运行时对象的引用。
            // exec(String[] cmdarray) 在单独的进程中执行指定命令和变量。
            System.out.println(Arrays.toString(strs));
            Process pr = Runtime.getRuntime().exec(strs);
            //使用缓冲流接受程序返回的结果
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));//注意格式
            //定义一个接受python程序处理的返回结果
            String line=" ";
            int i = 0;
            while((line=in.readLine())!=null) {
                //循环打印出运行的结果
//                if (i == 0) {
//                    result.append(line);
//                }
//                else {
//                    result.append(line);
//                }
//                i++;
//                result.append(line);
//                System.out.println(result.toString());

                System.out.println(line);
                SseEmitterServer.sendMessage(videoId, line);

            }
            //关闭in资源
            in.close();
            pr.waitFor();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
