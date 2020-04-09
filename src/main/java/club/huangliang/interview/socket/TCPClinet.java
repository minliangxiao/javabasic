package club.huangliang.interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClinet {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        Socket socket =new Socket("127.0.0.1",65000);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        //向输输出流中写数据
        os.write(new String("hello world").getBytes());
        int ch=0;
        byte[] buff=new byte[1024];
        //将输入流中的数据读取到byte数组中
        ch=is.read(buff);
        String content=new String(buff,0,ch);
        //将服务器传过来的数据打印出来
        System.out.println(content);
        is.close();
        os.close();
        socket.close();

    }
}
