package club.huangliang.interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LengthCalculator extends Thread {
    //以socket为成员变量
    private Socket socket;
    public LengthCalculator(Socket socket){
        this.socket=socket;
    }

    @Override
    public void  run(){
        try {
            //获取socket里面的输出流
            OutputStream os = socket.getOutputStream();
            //获取socket里面的输入流
            InputStream is =socket.getInputStream();
            int ch=0;
            byte[] buff=new byte[1024];
            //buff主要用来读取输入的内容，存成byte数组，ch主要用来获取数组的大小，将输入流的数据读取到buff中
            ch=is.read(buff);
            //将byte数组转换成字符串，这里获取到的内容是客户端发过来的字符
            String content=new String(buff,0,ch);//这是一个0表示从哪里开始，ch表示在哪里结束
            System.out.println(content);
            os.write(String.valueOf(content.length()).getBytes());
            //关闭资源
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
