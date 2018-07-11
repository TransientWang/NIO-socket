package nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

public class QQSever {
    private ServerSocketChannel serverSocketChannel;
    private Charset charset = Charset.forName("utf-8");
    private Selector selector;

    public QQSever() throws IOException {
        this.serverSocketChannel = ServerSocketChannel.open();
        this.selector = Selector.open();
    }

    public void init() throws IOException {

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 30000));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("注册完成");
        int num =selector.select();
        while (num > 0) {
            System.out.println(num);
            System.out.println("通道已经准备就绪");
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey key : selectionKeys) {


                if (key.isAcceptable()) {
                    System.out.println("接受通道");
                    SocketChannel SChannel = serverSocketChannel.accept();
                    SChannel.configureBlocking(false);
                    SChannel.register(selector, SelectionKey.OP_READ);

                }

                if (key.isReadable()) {

                    System.out.println("读就绪");
                    SocketChannel readsocket = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(48);
                    StringBuilder stringBuilder = new StringBuilder();
                    while (readsocket.read(byteBuffer) > 0) {
                        byteBuffer.flip();
                        stringBuilder.append(charset.decode(byteBuffer));
//                        System.out.println(stringBuilder);
                        byteBuffer.clear();

                    }

                    if (stringBuilder.length() > 0){
                        readsocket.write(charset.encode(stringBuilder.toString()));
                    }

                }
                selectionKeys.remove(key);
            }
            num = selector.select();
        }
    }

    public static void main(String[] args) throws IOException {
        QQSever qqSever = new QQSever();
        qqSever.init();

    }
}
