package 문자열;
import java.io.*;
import java.util.*;

public class 단어공부1157 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s[] = sc.next().split("");			//문자열을 입력 받아서 한개씩 나눠준다. 
		int ans[] = new int[27];
		
		for(int i=0; i<s.length; i++) {
			s[i]=s[i].toUpperCase();				//모두 대문자로 변경 
		}
		
		for(char i='A'; i<='Z'; i++) {
			
			for(int j=0; j<s.length; j++) {
				if(s[j].charAt(0)==i) {				//입력문자와 같은것이 있다면 개수를 ans배열에 ++ 해준다.
					ans[s[j].charAt(0)-'A']++;
				}
			}
		}
		
		int max=0;										
		char ch = '?';
		for(int i=0; i<ans.length; i++) {
			if(ans[i]>max) {						//최대값을 갱신해준다.
				max=ans[i];							//최대값 갱신 
				ch= (char)(i+'A');					//최대로 개수가 많은 문자를 ch에 담아준다.
			}else if(ans[i]==max) {
				ch='?';								//최대값이 같다면 ?출력 
			}
		}
		
		System.out.println(ch);
				
	}
}



