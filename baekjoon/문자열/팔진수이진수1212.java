package 문자열;

import java.io.*;
import java.util.*;

public class 팔진수이진수1212 {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();						//문자열로 입력값을 받는다.
		StringBuilder sb = new StringBuilder();
		
		for(char c:s.toCharArray()) {					//문자를 하나씩 가져온다.

			switch(c) {			
				
			case '0':sb.append("000");	break;			//8진수 이므로 1~7까지밖에 없어서 switch case문을 사용 찾은경우 break 해준다.
			case '1':sb.append("001");	break;
			case '2':sb.append("010");	break;
			case '3':sb.append("011");	break;
			case '4':sb.append("100");	break;
			case '5':sb.append("101");	break;
			case '6':sb.append("110");	break;
			case '7':sb.append("111");	break;
			}
		}
		
		if(sb.charAt(0)=='0') sb.deleteCharAt(0);		//앞 두자리가 0일경우 제거해준다. 
		if(sb.charAt(0)=='0') sb.deleteCharAt(0);
		System.out.println(sb.toString());
	}
}