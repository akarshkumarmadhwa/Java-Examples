import java.io.*;
import java.net.*;
import java.util.*;
public class TCPClient {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Socket skt = new Socket("localhost",1025);
			DataInputStream din = new DataInputStream(skt.getInputStream());
			DataOutputStream dout = new DataOutputStream(skt.getOutputStream());
			System.out.println("Enter the filename");
			String str = in.readLine();
			String str1;
			dout.writeBytes(str+"\n");
			System.out.println("Enter new filename");
			String str2 = in.readLine();
			FileWriter f = new FileWriter(str2);
			char buffer[];
			while(true) {
				str1 = din.readLine();
				if(str1.equals("-1")) break;
				System.out.println(str1);
				buffer = new char[str1.length()];
				str1.getChars(0, str1.length(), buffer, 0);
				f.write(buffer);
			}
			f.close();
			skt.close();
		}
		catch(Exception e) {System.out.println(e);}
	}
}
