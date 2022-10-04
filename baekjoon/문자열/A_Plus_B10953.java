package 문자열;


import java.io.*;
import java.util.*;

public class A_Plus_B10953 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();				
		for(int i=0; i<n; i++) {
			String s[] = sc.next().split(",");				//,를 기준으로 입력값을 나눠준다.				
			int sum=0;
			for(int j=0; j<s.length; j++) {		
				int a=Integer.parseInt(s[j]);				
				sum+=a;										//값을 더해준다.
			}
			System.out.println(sum);						//출
		}
	}
}

