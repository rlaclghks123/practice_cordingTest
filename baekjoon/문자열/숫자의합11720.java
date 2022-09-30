package 문자열;

import java.io.*;
import java.util.*;


public class 숫자의합11720 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();						//숫자의 개수를 입력받는다. 
		String s[] = sc.next().split("");		//입력값이 붙어있기 때문에 ""을 기준으로 배열에 담는다.
		int sum=0;
		
		for(int i=0; i<n; i++) {
			sum+=Integer.parseInt(s[i]);		//int형으로 바꿔준뒤, sum에 모든 값을 합해준다.
		}
		System.out.println(sum);				//총합을 출력 
	}
}

