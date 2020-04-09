package club.huangliang.interview.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器端的socket（服务端接受客服端发送的数据报）
        DatagramSocket socket=new DatagramSocket(65001);//监听65001端口
        byte[] buff=new byte[1024];//接收从客户端传来的内容
        //创建一个DatagramPacket对象用于储存客户端发过来的内容
        DatagramPacket packet=new DatagramPacket(buff,buff.length);//接受udp发送过来的报文信息
        //接受客服端发过来的内容，并将内容分装到DatagramPacket对象中
        socket.receive(packet);
        //将数据放入data字节数组
        byte[] data =packet.getData();//获取到DatagramPacket对象中获取到正真储存的数据
        String content=new String(data,0,packet.getLength());
        System.out.println(content);
        //获取到客户端传过来的字符长度，并将之转换成byte类型
        byte[] senddContent=String.valueOf(content.length()).getBytes();
        //整理要发往客户端的信息
        DatagramPacket packetToClient=new DatagramPacket(senddContent,senddContent.length,
                packet.getAddress(),packet.getPort());
        //发送数据
        socket.send(packetToClient);
    }
}
