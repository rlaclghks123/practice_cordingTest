package 문자열;


import java.io.*;
import java.util.*;

public class 크로아티아알파벳2941 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		String s = sc.next();				//문자열을 입력받는다.		
		int cnt = 0;						//크로아티아 알파벳 개수를 담을 변수 
		int len = s.length();				//반복되기 때문에 짧은 len으로 선언 
		
		for(int i=0; i<len; i++) {
			char now = s.charAt(i);
			
			if(now=='c' && i+1<len) {							 //현재값이 c이면서 다음값이 범위 내에 있다면 
				if(s.charAt(i+1)=='=' || s.charAt(i+1)=='-') { 	 //다음값이 = 이거나 - 일경우  i++을통해 건너뛴다.
					i++;
				}
			}
		
			else if(now=='d' && i+1<len) {
				if(s.charAt(i+1)=='-') {
					i++;
				}
				else if(s.charAt(i+1)=='z' && i+2<len) {
					if(s.charAt(i+2)=='=') {
						i+=2;
					}
				}
			}
			
			else if((now=='l' || now=='n') && i+1<len) {
				if(s.charAt(i+1)=='j') {
					i++;
				}
			}
			
			else if((now=='s' || now=='z') && i+1<len) {
				if(s.charAt(i+1)=='=') {
					i++;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}	
}

//c=
//c-

//dz=
//d-

//lj
//nj

//s=
//z=

