package 문자열;


import java.io.*;
import java.util.*;

public class 균형잡힌세상4949 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String s = sc.nextLine();
			if(s.equals(".")) break;				//입력값이 . 일경우 break
			
			if(check(s)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
	
	public static boolean check(String s) {
		Stack<Character> st = new Stack<>();			//LIFO 방식인 stack 사용
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c=='(' || c=='[') {						//괄호를 여는 부분이면 스택에 넣어준다.
				st.push(c);
			}
			else if(c==')') {							//소괄호를 닫는부분이면 
				if(st.isEmpty() || st.peek()!='(') {	//스택이 비어있거나, 제일 마지막괄호가 소괄호가 아닐경우 false 출력 
					return false;
				}else {									//그게 아닐경우 괄호를 빼준다. 
					st.pop();
				}
			}
			else if(c==']') {							//대괄호를 닫는부분이면
				if(st.isEmpty() || st.peek()!='[') {   	//스택이 비어있거나, 제일 마지막괄호가 대괄호가 아닐경우 false 출력
					return false;
				}else {									//그게 아닐경우 괄호를 빼준다.
					st.pop();
				}
			}
		}
		if(st.isEmpty()) {					//스택이 비어있을경우 즉 괄호의 짝이 맞을경우  true 출력 
			return true;
		}
		else {								//스택이 비어있지 않을경우 즉 괄호의 짝이 맞지않는경우 false출력
			return false;
		}
	}
}