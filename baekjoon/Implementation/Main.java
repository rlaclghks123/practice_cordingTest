package Implementation;

import java.util.Scanner;

public class Main {

	static boolean c[];
	
	public static void main(String[] args) {
		
		int arr[] = new int[10001];
		c = new boolean[10001];
		for(int i=1; i<=10000; i++) {
		
			int n=d(i);
			
			if(n<10001) {
				c[n]=true;
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(c[i]==false) {
				System.out.println(i);
			}
		}
	}
	
	public static int d(int n) {
		int sum=n;
		while(n!=0) {
			sum=sum+(n%10);
			n/=10;
		}
		return sum;
	}
	
//	3
//	happy
//	new
//	year
}
