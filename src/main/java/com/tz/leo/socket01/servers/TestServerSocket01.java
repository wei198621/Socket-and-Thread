package com.tz.leo.socket01.servers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: tz_wl
 * Date: 2020/8/9 9:47
 * Content:
 */
public class TestServerSocket01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8989);
        //System.out.println(" serverSocket is running ... " + new Date());

        //让服务器端  一直刷新循环等待
        while(true) {

            Socket socket = serverSocket.accept();
            //System.out.println("has accept socket from client " + new Date());

            //step01  将从 客户端socket 发过来的数据 放到 InputStream 里面
            InputStream inputStream = socket.getInputStream();
            StringBuilder sb = new StringBuilder();
            int len = 0;
            byte[] tmpBytes = new byte[1024];
            while (true) {
                //每次取 单位字节 的数据到 临时byte 变量里面
                len = inputStream.read(tmpBytes);
                if (len == -1) {
                    break;
                }
                //将byte 转换为string
                String tmpStr = new String(tmpBytes, 0, len);
                //累加数据
                sb.append(tmpStr);
            }
            System.out.println("***********  the message is from client ************");
            System.out.println(sb.toString());
            System.out.println("***********  the message is from client ************");
            socket.shutdownInput();

            //step02  将相应结果发送给客户端
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello client , this is server 8989".getBytes());
            socket.shutdownOutput();

        }

    }
}
