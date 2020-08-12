package com.tz.leo.socket01.clients;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Author: tz_wl
 * Date: 2020/8/9 9:48
 * Content:
 */
public class TestSocket01 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8989);
       // System.out.println(" send socket from socket "+ new Date());

        //step1  发送客户端数到服务器
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server , I am Client 008".getBytes());
        //关闭 output  一定要添加  否则  服务端不清楚什么时候结束   报错
        socket.shutdownOutput();   //shutdownOutput 与 getOutputStream 成对出现

        //step2  相应服务器端返回数据 并打印
        InputStream inputStream = socket.getInputStream();
        StringBuilder sb=new StringBuilder();
        int len=0;
        byte[] tmpBytes = new byte[1024];
        while(true){
            len = inputStream.read(tmpBytes);
            if(len==-1){
                break;
            }
            String tmpStr = new String(tmpBytes, 0, len);
            sb.append(tmpStr);
        }
        System.out.println("***********  the message is from server ************");
        System.out.println(sb);
        System.out.println("***********  the message is from server ************");
        socket.shutdownInput();


       // System.out.println("close socket !!1");
    }
}
