package 문자열;

import java.io.*;
import java.util.*;

public class 접미사배열11656 {
	 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();							//문자열 입력받는다.
		ArrayList<String> arr =new ArrayList<>();		//접미사를 담을 배열  
		
		for(int i=0; i<s.length(); i++) {				//i부터~s.length까지 1칸씩 증가해서 접미사를 구한다.
			arr.add(s.substring(i,s.length()));	
		}
		
		Collections.sort(arr);							//사전순으로 정렬 
		
		for(String st: arr) {
			System.out.println(st);						//접미사들을 출력한다.
		}
	}
}