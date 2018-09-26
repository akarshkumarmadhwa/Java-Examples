import java.util.Random;
import java.util.Scanner;
public class LBA {
	public static void main(String args[]) {
		int bktsize,iter,operate,line,total=0,rem;
		int pkt[] = new int[25];
		Scanner s = new Scanner(System.in);
		System.out.println("Enter line");
		line = s.nextInt();
		System.out.println("enter iterators");
		iter = s.nextInt();
		System.out.println("Enter bucket size & input rate");
		bktsize = s.nextInt();
		operate = s.nextInt();
		Random r = new Random();
		for(int i=0;i<iter;i++) {
			System.out.println("Iteration: "+(i+1));
			for(int j=0;j<line;j++) {
				r.setSeed(System.nanoTime());
				pkt[j] = r.nextInt(500);
				total += pkt[j];
				if(total <= bktsize)
					System.out.println("Input from line "+(j+1)+" with packet size "+pkt[j]+" bytes are accepted for the bucket number of bytes in bucket is: "+total);
				else {
					total -= pkt[j];
					System.out.println("Input from line "+(j+1)+" with packet size "+pkt[j]+" bytes are accepted for the bucket number of bytes in bucket is: "+total);
				}
			}
			if(operate > total) {
				rem = total;
				total = 0;
				System.out.println("---------------------------------------");
				System.out.println("Output rate of the bucket is "+operate+"\n bytes sent out of the bucket is"+rem);
				System.out.println("---------------------------------------");
			}
			else {
				total -= operate;
				System.out.println("---------------------------------------");
				System.out.println("Output rate of the bucket is "+operate+"\n bytes remaining "+total);
				System.out.println("---------------------------------------");
			}
		}
	}

}
