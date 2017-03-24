package tools;
import java.util.Scanner;

public class easyIO {
	
	public void write(String arg) {
		System.out.print(arg);
	}
	
	public void writeL(String arg) {
		System.out.println(arg);
	}

	public void writeN(int arg) {
		System.out.print(arg);
	}
	
	public String readS() {
		return new Scanner(System.in).nextLine();
	}
	
	public int readN() {
		return new Scanner(System.in).nextInt();
	}
	
	public double readD() {
		return new Scanner(System.in).nextDouble();
	}
	
	public char readC() {
		return new Scanner(System.in).nextLine().charAt(0);
	}
}
