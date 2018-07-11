import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class ProxFactory {
    public static void main(String[] args) {

//        play player = (play) Proxy.newProxyInstance(ProxFactory.class.getClassLoader(), new Class[]{play.class},
//                new InvocationHandler() {
//
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println(method.getName());
//
//                        return null;
//                    }
//                });
//
//        player.doPlay();
        System.out.println("请从键盘输入：");
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            //读取键盘输入
            String line=scan.nextLine();
            //将键盘输入的内容输出到SocketChannel中
            System.out.println("输入:"+line);
        }
    }

}
