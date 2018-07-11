import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NClient {

    //定义检测SocketChannel的Selector对象,该selector箭筒病接受服务端传来的channel信息
    private Selector selector=null;
    //定义处理编码和解码的字符集
    private Charset charset=Charset.forName("UTF-8");
    //客户端SocketChannel
    private SocketChannel sc=null;
    public void init() throws IOException{
        selector=Selector.open();
        InetSocketAddress isa=new InetSocketAddress("127.0.0.1",30000);
        //调用open静态方法创建连接到指定主机的SocketChannel
        sc=SocketChannel.open(isa);
        //设置该sc以非阻塞方式工作
        sc.configureBlocking(false);
        //将Socketchannel对象注册到指定Selector，并为该channel绑定可读监听事件
        sc.register(selector, SelectionKey.OP_READ);
        //启动读取服务器端数据的线程
        new ClientThread().start();
        //创建键盘输入流
        System.out.println("请从键盘输入：");
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            //读取键盘输入
            String line=scan.nextLine();
            //将键盘输入的内容输出到SocketChannel中
            sc.write(charset.encode(line));
        }
    }
    //定义读取服务器数据的线程
    private class ClientThread extends Thread{
        public void run(){
            try{
                //掉用select()方法获取从上次调用该方法后已经准备就绪channel的所有selectionKey
                while(selector.select()>0){
                    //获取所有key的set集合，遍历每个有可用IO操作Channel对应的SelectionKey
                    for(SelectionKey sk:selector.selectedKeys()){
                        //手动删除放在set里面的key，以便再次调用select方法时再次将已准备好的
                        // chennel放到set中。

                        selector.selectedKeys().remove(sk);
                        //如果该SelectionKey对应的Channel可读
                        if(sk.isReadable()){
                            //根据selectionkey获取到对应的chanel。（类似key value）
                            // 使用NIO读取channel中的数据
                            SocketChannel sc=(SocketChannel) sk.channel();
                            ByteBuffer buff=ByteBuffer.allocate(1024);
                            StringBuilder content = new StringBuilder();
                            while(sc.read(buff)>0){
                                //sc.read(buff);
                                buff.flip();
                                content.append(charset.decode(buff));
                            }
                            //打印输出读取的内容
                            System.out.println("聊天信息"+content);
                            //为下一次读取做准备  interestOps
                            sk.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[]args) throws IOException{
        new NClient().init();
    }

}
