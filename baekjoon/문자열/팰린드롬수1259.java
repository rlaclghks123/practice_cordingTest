package 문자열;
	
import java.io.*;
import java.util.*;

public class 팰린드롬수1259 {

		
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				String s =sc.next();				//문자열 입력 		
				if(s.equals("0")) break;			//0일경우 반복문 탈출
				
				int len = s.length();				//총 길이를 담을 변수(홀,짝 구별을 위해)
				Stack<Character> st = new Stack<>();
				
				for(int i=0; i<len/2; i++) {		//숫자의 절반을 스택에 넣어준다. 
					char c = s.charAt(i);
					st.push(c);
				}
				
				
				if(len%2==0) {						//짝수일경우 
					
					for(int i=len/2; i<len; i++) {	//절반이후부터 끝까지 문자를 살펴본다.
						char c = s.charAt(i);
						if(st.peek()==c) {			//스택안에 마지막수와 같을경우 
							st.pop();				//스택에서 뺀다.
						}else {
							System.out.println("no");	//다를경우 팰린드롬수가 아니므로 no 출력
							break;
						}
					}
				}
				if(len%2==1) {						//홀수일경우 
				
					for(int i=len/2+1; i<len; i++) {	//중간값을 건너뛰고 그 다음값부터 끝까지 
						char c = s.charAt(i);			//살펴본뒤 
						if(st.peek()==c) {				//스택의 마지막값과 같으면 
							st.pop();					//스택에서 빼준다.
						}else {
							System.out.println("no");	//다를경우 팰린드롬수가 아니므로 no 출력 
							break;
						}
					}
				}
				if(st.isEmpty()) {
					System.out.println("yes");			//비어있다면 yes 출력 
				}
			}
		}
	}

