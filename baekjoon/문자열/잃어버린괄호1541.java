package 문자열;

import java.io.*;
import java.util.*;

public class 잃어버린괄호1541 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s[] = sc.nextLine().split("-");				//-를 기준으로 우선 나눠준다.(-가 결과값을 크게 바꾸기 때문)
		int sum=Integer.MAX_VALUE;							//최소값을 구하기 위해 최대값을 초기값으로 지정 
		
		for(int i=0; i<s.length; i++) {
			int temp = 0;
			String str[] = s[i].split("\\+");				//+를 기준으로 다시한번 나눠준다.
			
			for (int j=0; j<str.length; j++){		
				temp+=Integer.parseInt(str[j]);				//+인 부분을 다 더해준다.
			}
			if(sum==Integer.MAX_VALUE) {					//초기값이 최대값일 경우 현재값으로 변경 
				sum=temp;
			}else {											//총 값을 temp의 값으로 빼준다.
				sum-=temp;
			}
		}		
			System.out.println(sum);					
	}
}
