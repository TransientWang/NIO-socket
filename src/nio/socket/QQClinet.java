package nio.socket;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QQClinet {
    private SocketChannel socketChannel;
    private Selector selector;

    private Charset charset = Charset.forName("utf-8");

    public QQClinet() throws IOException {
        this.socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
        this.selector = Selector.open();
    }

    public void init() throws IOException {
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new CliThread()).start();

//        System.out.println("请从键盘输入：");
//        Scanner scan = new Scanner(System.in);
//        while (scan.hasNextLine()) {
//            //读取键盘输入
//            String line = scan.nextLine();
//            //将键盘输入的内容输出到SocketChannel中
//
//            socketChannel.write(charset.encode(line + ":= 123456"));
//        }

        while (true){
            socketChannel.write(charset.encode(String.valueOf(1)));
        }

    }

    private class CliThread implements Runnable {

        @Override
        public void run() {
            System.out.println("线程启动");
            try {
                System.out.println("进入try代码块");

                while (selector.select() > 0) {     //可以用while是因为服务端接受到信息后有返回了信息 再次判断while条件时候又有就绪事件了
                    System.out.println("执行select");
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        if (selectionKey.isReadable()) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                            while (socketChannel.read(byteBuffer) > 0) {
                                byteBuffer.flip();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(charset.decode(byteBuffer));

                                byteBuffer.clear();
                                System.out.println("客户端接受数据：" + stringBuilder);

                            }
                            selectionKeys.remove(selectionKey);
                        }
                    }

                    System.out.println("执行完毕");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{

            QQClinet qqClinet = null;
            try {
                qqClinet = new QQClinet();
                qqClinet.init();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
}
