package 문자열;

import java.io.*;
import java.util.*;

public class 펠린드롬인지확인하기10988 {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();						//문자열 입력 
		int len = s.length();						//길이가 자주 반복되므로 변수로 지정 
		
		Stack<Character> st = new Stack<>();		//스택 생성 
		
		for(int i=0; i<len/2; i++) {				//절반을 스택에 넣어준다.
			st.push(s.charAt(i));
		}
		
		if(len%2==0) {								//짝수일경우 
			for(int i=len/2; i<len; i++) {			//길이/2 부터 길이까지 반복
				if(st.peek()==s.charAt(i)) {		//스택의 마지막값과 현재값이 같을경우 
					st.pop();						//스택에서 제거 
				}
				else {								//스택의 마지막값과 현재값이 다를경우
					System.out.println(0);			//0출력후 종료 
					return;
				}
			}	
		}
		else if(len%2==1) {							//홀수일경우 
			for(int i=len/2+1; i<len; i++) {		//길이/2+1 부터 길이까지 반복 
				if(st.peek()==s.charAt(i)) {		//스택의 마지막값과 현재값이 같을경우 
					st.pop();						//스택에서 제거 
				}
				else {								//스택의 마지막값과 현재값이 다를 경우 
					System.out.println(0);			//0 출력후 종료 
					return;
				}
			}
		}
		if(st.isEmpty()) {							//스택이 비어있다면 (펠린드롬이므로)1출력 
			System.out.println(1);
		}
	}
}
