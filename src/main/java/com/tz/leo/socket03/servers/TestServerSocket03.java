package com.tz.leo.socket03.servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/8/9 13:56
 * Content:
 */
public class TestServerSocket03 {

    ///

    public static void main(String[] args) throws IOException, InterruptedException {
        //创建serverSocket 对象
        //
        ServerSocket serverSocket = new ServerSocket(8989);
        System.out.println("《服务端打印数据》=== 服务端已经启动 ");

        while (true) {
            //接受客户端请求
            final Socket socket = serverSocket.accept();


            //使用 thread 方式创建线程 的缺点
            //1.  服务端 为 每个客户端 开启一个新的线程 ，高并发下 系统达到 上限 无法创建
            //2.  每个线程只使用一次，利用率不高
            //3.  频繁创建线程导致cpu使用率 居高不下
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        //01  获取客户端的输入数据  并显示
                        //用下面四句 完成之前 10句 内容  之前处理input 需要 定义 Byte[] 缓存 while 循环获取
                        //处理请求数据
                        InputStream inputStream = socket.getInputStream();
                        //封装过滤流
                        DataInputStream dataInputStream = new DataInputStream(inputStream);
                        String readUTF = dataInputStream.readUTF();
                        System.out.println("《服务端打印数据》===" + readUTF + " 线程名称：" + Thread.currentThread().getName()+ "; 时间： "+ new Date());
                        socket.shutdownInput();

                        //02  业务处理
                        //同一个线程 测试线程休眠影响其他客户端数据
                         if(readUTF.equals("client03")){
                            Thread.sleep(20000);
                        }
                        //03   返还信息给client
                        //响应客户端对象
                        OutputStream outputStream = socket.getOutputStream();
                        //封装过滤流
                        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                        dataOutputStream.writeUTF("你好这里是服务端返回数据，已经接收到你个的信息");
                        socket.shutdownOutput();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();


        }

    }
}
