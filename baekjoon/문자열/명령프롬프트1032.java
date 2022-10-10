package 문자열;

import java.io.*;
import java.util.*;

public class 명령프롬프트1032 {
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Character> arr = new ArrayList<>();
		
		int t=sc.nextInt();
		
		for(int i=0; i<t; i++) {
			String s=sc.next();				//문자열을 입력받는다.
 

				if(i==0) {						//처음일경우 처음 문자를 arr에 넣어준다.
					for(char c:s.toCharArray()) {
					arr.add(c);		
					}
				}else {
					for(int j=0; j<s.length(); j++) {
						char c=s.charAt(j);
					if(c==arr.get(j)) {			//처음이 아닐경우 arr에 있는 문자와 비교해서 같다면 
						continue;				//넘어간다.
						
					}else {						//다르다면 
						arr.remove(j);			//그 문자를 제거한뒤 
						arr.add(j, '?');			//그 index값에 ?를 담아준다.
					}
				}
			}
		}
		for(char c:arr) {						//arr에 있는 문자를 출력해준다.
			System.out.print(c);
		}
	}
}