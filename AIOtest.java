package haha.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;

/**
 * @author 王扶摇
 * @Title: AIOtest
 * @ProjectName test
 * @date 2018/8/23 9:36
 */

public class AIOtest {
    public static void d() throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel
                .open()
                .bind(new InetSocketAddress("127.0.0.1",9999));
          serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
              @Override
              public void completed(AsynchronousSocketChannel result, Object attachment) {
                  System.out.println("接受到请求");
                  serverSocketChannel.accept(null,this);
              }

              @Override
              public void failed(Throwable exc, Object attachment) {

              }
          });


    }

    public static void a() throws IOException {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel
                .open()
                .bind(new InetSocketAddress("127.0.0.1",9110));

        socketChannel.connect(new InetSocketAddress("127.0.0.1",9999), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                System.out.println("客户端连接成功");
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
    }

    public static void main(String[] args) {

        try {
            AIOtest.d();

            AIOtest.a();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
