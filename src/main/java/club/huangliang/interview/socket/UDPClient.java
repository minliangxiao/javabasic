package club.huangliang.interview.socket;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //创建一个udp的socket>>DatagramSocket
        DatagramSocket socket=new DatagramSocket();
        byte[] buff="Hello World".getBytes();
        //将IP地址封装成InetAddress对象
        InetAddress address=InetAddress.getByName("127.0.0.1");
        //将要发送给服务端的数据封装成DatagramPacket对象  树妖写上ip地址与端口号
        DatagramPacket sendpacket=new DatagramPacket(buff,buff.length,address,65001);
        //发送给服务器数据
        socket.send(sendpacket);
        //客户端接受服务端发送过来的数据报
        byte[] data=new byte[100];
        //创建DatagramPacket对象用来存储服务端发过来的数据
        DatagramPacket receivedPacket=new DatagramPacket(data,data.length);
        socket.receive(receivedPacket);
        String content=new String(receivedPacket.getData(),0,receivedPacket.getLength());
        System.out.println(content);
    }
}
