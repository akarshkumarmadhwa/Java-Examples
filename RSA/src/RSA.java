import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
public class RSA {
	private BigInteger p,q,n,m,e,d;
	private int bitlen = 1024;
	private Random r;
	public RSA() {
		r = new Random();
		p = BigInteger.probablePrime(bitlen, r);
		q = BigInteger.probablePrime(bitlen, r);
		n = p.multiply(q);
		m = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(bitlen/2, r);
		while(m.gcd(e).compareTo(BigInteger.ONE)> 0 && e.compareTo(m) < 0)
			e.add(BigInteger.ONE);
		d = e.modInverse(m);
	}
	public RSA(BigInteger e, BigInteger d, BigInteger n) {
		this.e = e;
		this.d = d;
		this.n = n;
	}

	public static void main(String args[]) throws IOException{
		RSA rsa = new RSA();
		boolean t = true;
		int l;
		while(t) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Message:");
		String test = s.nextLine();
		System.out.println("Encrypting String:" +test);
		
		System.out.println("String in Bytes:"+byteToString(test.getBytes()));
		byte[] encypted = rsa.encrypt(test.getBytes());
		System.out.println("Cipher Text: "+encypted);
		byte[] decrypted = rsa.decrypt(encypted);
		System.out.println("Decrypting Bytes:"+byteToString(decrypted));
		System.out.println("Decrypting String:"+new String(decrypted));
		System.out.println("continue(1/0)");
		l = s.nextInt();
		if(l==1)
			t = true;
		else
			t = false;
	}
	}
	private static String byteToString(byte[] encrypted) {
		String test="";
		for(byte b: encrypted)
			test += Byte.toString(b);
		return test;
	}
	public byte[] encrypt(byte[] msg) {
		return (new BigInteger(msg)).modPow(e, n).toByteArray();
	}
	public byte[] decrypt(byte[] msg) {
		return (new BigInteger(msg)).modPow(d, n).toByteArray();
	}
}
