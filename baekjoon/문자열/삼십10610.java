package 문자열;

import java.io.*;
import java.util.*;

public class 삼십10610 {
	 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();			//범위가 크기때문에 int,long이 아닌 string으로 받는다.
		int strCount [] = new int[10];
		long total = 0;
		
		for(int i=0; i<s.length(); i++) {
			int temp = Integer.parseInt(s.substring(i,i+1)); 	//숫자 한개씩 int로 바꿔준다.
			strCount[temp]++;										//현재값의 개수를 찾아주고
			total+=temp;										//모든 자리의 값들을 더해준다.
		}
		
		if(!s.contains("0") || total%3 !=0) {					//30의 배수가 될 조건이 3의 배수이면서, 0이 포함되어 있어야한다.
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=9; i>=0; i--) {							//큰수를 구하기 위해 내림차순으로 설정한다.
			while(strCount[i]>0) {							//개수가 0일때까지 반복 
				sb.append(i);								//값을 넣어준다.
				strCount[i]--;								//sb에 추가했으면, 개수를 빼준다.
			}
		}
		System.out.println(sb);
	}
}