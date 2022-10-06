package 문자열;

import java.io.*;
import java.util.*;

public class 알파벳개수10808 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		String s =sc.next();					//문자열을 입력받는다.
		
		int ans[] = new int[26];				//알파벳 개수를 담을 배열 	
			
		for(int j=0; j<s.length(); j++) {
			char c = s.charAt(j);				//입력받은 문자열에서 각각의 알파벳을 찾는다.
			ans[c-'a']++;						//알파벳의 개수를 +1 해준다.
		}
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");		//총 알파벳의 개수를 출력해준다.
		}
	}
}

