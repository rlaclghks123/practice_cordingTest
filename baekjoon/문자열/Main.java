package 문자열;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0) {
			int n=sc.nextInt();
			String s =sc.next();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				for(int j=0; j<n; j++) {
					System.out.print(c+"");
				}
			}
			System.out.println();
			
		}
	}
}
