package haha.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

/**
 * @author 王扶摇
 * @Title: NIOtest
 * @ProjectName test
 * @date 2018/8/23 14:12
 */

public class NIOtest {
    public static void aa(){
        Selector selector  = null;

        ServerSocketChannel serverSocketChannel  = null;

        try {
            selector = SelectorProvider.provider().openSelector();
            serverSocketChannel = ServerSocketChannel
                    .open()
                    .bind(new InetSocketAddress("127.0.0.1",10001));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            Charset charset = Charset.forName("utf-8");
            while (true){
                if (selector.select() > 0){


                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();

                        if ((key.interestOps()& SelectionKey.OP_READ) >0 && key.isReadable()){
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            System.out.println("有人输入");
                            socketChannel.shutdownInput();
                            iterator.remove();
//                           while (true){
//                              if (socketChannel.read(byteBuffer)>0){
//
//                                  byteBuffer.flip();
//                                  StringBuilder stringBuilder = new StringBuilder(charset.decode(byteBuffer));
//                                  System.out.println(stringBuilder.toString());
//                                  byteBuffer.clear();
//
//                              }
//
//                           }
                        }else if ((key.interestOps()& SelectionKey.OP_ACCEPT) >0 && key.isAcceptable()){
                            ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
                            System.out.println(socketChannel);
                            socketChannel.configureBlocking(false);
                            System.out.println("有人连接");
                            SocketChannel channel = socketChannel.accept();
                            if (channel != null) {


                                channel.configureBlocking(false);

                                channel.register(selector, SelectionKey.OP_READ);
                            }
                            iterator.remove();
                            socketChannel.register(selector,SelectionKey.OP_ACCEPT);
                        }

                    }


                }

            }

//            selector.selectedKeys().stream().forEachOrdered(o -> System.out.println(o.interestOps()));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public static void main(String[] args) {
        aa();




    }


}
