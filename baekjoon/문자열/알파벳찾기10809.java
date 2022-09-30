package 문자열;

import java.io.*;
import java.util.*;


public class 알파벳찾기10809 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s[] = sc.next().split("");			//입력값을 ""를 기준으로 분리해서 배열에 담아준다.
		int d[] = new int[26];
		Arrays.fill(d, -1);							//초기값을 -1로 설정하여, 해당되지 않으면 -1로 출력 하도록 
		
		for(int i=s.length-1; i>=0; i--) {			//뒤에서 부터 앞으로 오는 이유는 같은 알파벳일 경우 먼저나온 index값을 얻기위함 
			d[s[i].charAt(0)-'a'] = i;				//입력값의 알파벳 위치를 담아준다. 
		
		}
		
		for(int i=0; i<d.length; i++) {
			System.out.print(d[i]+" ");				//출력 
		}
	}
}
