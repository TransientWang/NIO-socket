package haha.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author 王扶摇
 * @Title: Client
 * @ProjectName test
 * @date 2018/8/23 14:40
 */

public class Client {


    public static void run(int port) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open()
                    .bind(new InetSocketAddress("127.0.0.1", 10000));

            System.out.println("请从键盘输入：");
            Scanner scan=new Scanner(System.in);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", port));
            while(scan.hasNextLine()){
                //读取键盘输入
                String line=scan.nextLine();
                //将键盘输入的内容输出到SocketChannel中
                socketChannel.write(ByteBuffer.wrap(line.getBytes()));
                socketChannel.shutdownOutput();
                if (!socketChannel.finishConnect()){
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", port));
                }

            }
            socketChannel.close();
            System.out.println(socketChannel.finishConnect());
            System.out.println(socketChannel.isOpen());

            System.out.println(socketChannel.isOpen());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        run(Integer.parseInt(args[0]));

    }
}
