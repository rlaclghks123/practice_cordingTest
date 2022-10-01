package 문자열;

import java.io.*;
import java.util.*;

public class 문자열반복2675 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0) {
			int n=sc.nextInt();		
			String s =sc.next();
			for(int i=0; i<s.length(); i++) {			
				char c = s.charAt(i);				//문자를 찾아준다. 
				for(int j=0; j<n; j++) {			//입력에서 주어진 크기만큼 반복해준다. 
					System.out.print(c+"");			
				}
			}
			System.out.println();					//한줄 띄어준다.
			 
		} 
	}
}

