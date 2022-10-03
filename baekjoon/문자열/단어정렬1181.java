package 문자열;

import java.io.*;
import java.util.*;

public class 단어정렬1181 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		String s[] = new String[n];
		
		for(int i=0; i<n; i++) {		//문자열을 입력 받는다. 
			s[i]=sc.next();
		}
		
		Arrays.sort(s, new Comparator<String>() {		//Comparator의 compare을 override 해서 내가 원하는 정렬을 해준다.
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {				//길이가 같다면 사전순으로 
					return s1.compareTo(s2);
				}else {
					return s1.length()-s2.length();			//길이가 다르다면 길이순으로 정렬 
				}
			}
		});
		
		System.out.println(s[0]);				
		for(int i=1; i<s.length; i++) {
			if(!s[i].equals(s[i-1])) {				//만약 같은값이 있다면 하나만 출력해준다.
				System.out.println(s[i]);
			}
		}
	}
}
