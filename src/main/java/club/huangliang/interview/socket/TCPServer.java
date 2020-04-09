package club.huangliang.interview.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
* 这是手写一个tcpServer
* */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSoket对象,并将ServerSoket对象绑定到65000
        ServerSocket ss=new ServerSocket(65000);
        while (true){
            //获取服务端发过来的请求
            Socket socket=ss.accept();
            //获取到请求执行业务逻辑
            new LengthCalculator(socket).start();//要让线程执行需要调用它的start（）方法
        }
    }
}
