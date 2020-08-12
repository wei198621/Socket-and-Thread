package com.tz.leo.socket03.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Author: tz_wl
 * Date: 2020/8/9 13:56
 * Content:
 */
public class TestSocket03 {
    public static void main(String[] args) throws IOException {

        //创建客户端对象
        Socket socket = new Socket("localhost", 8989);

        //01  发送数据给服务器
        OutputStream outputStream = socket.getOutputStream();
        //封装过滤流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("client03");
        socket.shutdownOutput();

        //02 业务处理

        //03 接受从服务器返回的数据
        InputStream inputStream = socket.getInputStream();
        //封装过滤流
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String readUTF = dataInputStream.readUTF();
        System.out.println("《客户端打印数据》==="+readUTF);
        socket.shutdownInput();

    }
}
