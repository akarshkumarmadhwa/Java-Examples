import java.io.*;
import java.net.*;
class UDPServer
{
public static DatagramSocket ds;
public static byte buffer[]=new byte[4024];
public static int clientport=1024,serverport=2000;
public static void main(String args[])throws Exception
{
ds=new DatagramSocket(clientport);
System.out.println("press ctrl+c to quit the prgm");
BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
InetAddress ia=InetAddress.getLocalHost();
while(true)
{
DatagramPacket p=new DatagramPacket(buffer,buffer.length);
ds.receive(p);
String psx=new String(p.getData(),0,p.getLength());
System.out.println("client: "+psx);
System.out.println("server: ");
String str=dis.readLine();
if(str.equals("end"))
break;
//buffer=str.getBytes();
ds.send(new DatagramPacket(str.getBytes(),str.length(),ia,serverport));
}
}
}