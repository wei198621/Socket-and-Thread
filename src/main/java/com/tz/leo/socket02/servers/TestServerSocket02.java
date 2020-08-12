package com.tz.leo.socket02.servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: tz_wl
 * Date: 2020/8/9 13:56
 * Content:
 */
public class TestServerSocket02 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建serverSocket 对象
        //
        ServerSocket serverSocket = new ServerSocket(8989);
        System.out.println("《服务端打印数据》=== 服务端已经启动 ");


        while (true) {
            //接受客户端请求
            Socket socket = serverSocket.accept();

            //01  获取客户端的输入数据  并显示
            //用下面四句 完成之前 10句 内容  之前处理input 需要 定义 Byte[] 缓存 while 循环获取
            //处理请求数据
            InputStream inputStream = socket.getInputStream();
            //封装过滤流
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String readUTF = dataInputStream.readUTF();
            System.out.println("《服务端打印数据》==="+readUTF+" 线程名称："+ Thread.currentThread().getName());
            socket.shutdownInput();

            //02  业务处理
            //同一个线程 测试线程休眠影响其他客户端数据
            /* if(readUTF.equals("client02")){
                Thread.sleep(20000);
            }*/

            //03   返还信息给client
            //响应客户端对象
            OutputStream outputStream = socket.getOutputStream();
            //封装过滤流
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("你好这里是服务端返回数据，已经接收到你个的信息");
            socket.shutdownOutput();
        }

    }
}
