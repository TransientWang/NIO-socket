import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {
    //用于检测所有Channel状态的Selector
    private Selector selector=null;
    //定义实现编码、解码的字符集对象
    private Charset charset=Charset.forName("UTF-8");
    public void init() throws IOException{
        selector=Selector.open();
        //通过open方法来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server=ServerSocketChannel.open();
        InetSocketAddress isa=new InetSocketAddress("127.0.0.1",30000);
        //将该ServerSocketChannel绑定到指定ip地址
        server.bind(isa);
        //设置ServerSocket以非阻塞方式工作
        server.configureBlocking(false);
        //将server注册到指定Selector对象,并绑定连接事件
        server.register(selector, SelectionKey.OP_ACCEPT);
        //阻塞到只少有一个通道在之前准备的事件上就绪了
        while(selector.select()>0){
            //依次处理selector上的每个已选择的SelectionKey
            for(SelectionKey sk:selector.selectedKeys()){
                //从selector上的已选择Key集中删除正在处理的SelectionKey
                selector.selectedKeys().remove(sk);
                //如果sk对用的channel已经连接就绪
                if(sk.isAcceptable()){
                    //调用accept方法接受连接，产生的socketCahnnel（1）则与其请求连接的
                    //socketChannel（一）对应，可以通过channel（1）用于channel（一）进行通信
                    //accept方法只能由serverSocketChannel调用
                    SocketChannel sc=server.accept();
                    //设置采用非阻塞模式，后才能注册selector
                    sc.configureBlocking(false);
                    //将该才获得到的socketChannel（1）向selector注册可读事件，用于通信
                    sc.register(selector, SelectionKey.OP_READ);
                    //将sk对应的Channel设置成准备接受其他请求
//                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                //如果sk对应的通道有数据需要读取
                if(sk.isReadable()){
                    //获取该SelectionKey对应的Channel，该Channel中有可读的数据
                    SocketChannel sc=(SocketChannel) sk.channel();
                    //定义准备之星读取数据的ByteBuffer
                    ByteBuffer buff=ByteBuffer.allocate(1024);
                    String content="";
                    //开始读取数据
                    try{
                        while(sc.read(buff)>0){
                            buff.flip();
                            content+=charset.decode(buff);
                        }
                        //打印从该sk对应的Channel里读到的数据
                        System.out.println("=========="+content);
                        //将此键的兴趣设置为给定值 如果一直接受读就绪就不用设置了，
                        // 要是读后再写想监听写就绪就要设置
//                        sk.interestOps(SelectionKey.OP_READ);

                        //如果捕捉到该sk对应的channel出现异常，即表明该channel对应的client出现了
                        //异常，所以从selector中取消sk的注册
                    }catch(IOException e){
                        //从Selector中删除指定的SelectionKey
                        sk.cancel();
                        if(sk.channel()!=null){
                            sk.channel().close();
                        }
                    }
                    //如果content的长度大于0，即聊天信息不为空
                    if(content.length()>0){
                        System.out.println("服务端接受到信息");
                        //遍历该selector里注册的所有SelectKey
                        for(SelectionKey key:selector.keys()){
                            //选取该key对应的Channel
                            Channel targetChannel=key.channel();

                            //
                            //如果该channel是SocketChannel对象
                            if(targetChannel instanceof SocketChannel){
                                //将独到的内容写入该Channel中
                                SocketChannel dest=(SocketChannel) targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[]args) throws IOException{
//        new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                new NClient().init();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }).start();
        new NServer().init();

    }
}
