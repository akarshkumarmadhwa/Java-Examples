import java.util.*;
import java.net.*;
import java.io.*;
public class TCPServer {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		try {
			ServerSocket skt = new ServerSocket(1025);
			while(true) {
				Socket skt1 = skt.accept();
				DataInputStream din = new DataInputStream(skt1.getInputStream());
				DataOutputStream dout = new DataOutputStream(skt1.getOutputStream());
				String str = din.readLine();
				FileReader f = new FileReader(str);
				BufferedReader b = new BufferedReader(f);
				String s;
				while((s=b.readLine())!=null) {
					System.out.println(s);
					dout.writeBytes(s+"\n");
				}
				f.close();
				dout.writeBytes("-1\n");
				
			}
		}
		catch(Exception e) {System.out.println(e);}
	}
}

