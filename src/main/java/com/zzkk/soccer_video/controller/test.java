package com.zzkk.soccer_video.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName test
 * @Description
 * @date 2023/2/24 14:48
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("java控制台输入问题：");
//        String instr = scanner.next();
        //定义个获取结果的变量
        String result="";
        int a = 0;
        try {
            //调用python，其中字符串数组对应的是python，python文件路径，向python传递的参数
            String[] strs=new String[] {"D:\\software\\Anaconda3\\envs\\py37\\python.exe","D:\\study\\proj\\soccer\\graduate_soccer_caption_event_detection\\test2.py"};
            //Runtime类封装了运行时的环境。每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。
            //一般不能实例化一个Runtime对象，应用程序也不能创建自己的 Runtime 类实例，但可以通过 getRuntime 方法获取当前Runtime运行时对象的引用。
            // exec(String[] cmdarray) 在单独的进程中执行指定命令和变量。
            Process pr = Runtime.getRuntime().exec(strs);
            //使用缓冲流接受程序返回的结果
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(),"GBK"));//注意格式
            //定义一个接受python程序处理的返回结果
            String line=" ";
            while((line=in.readLine())!=null) {
                //循环打印出运行的结果
//                result+=line+"\n";
                System.out.println(a + " + " + line + "\n");
                a ++;
            }
            //关闭in资源
            in.close();
            pr.waitFor();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\npython传来的结果：");
        //打印返回结果
        System.out.println(result);
    }
}
