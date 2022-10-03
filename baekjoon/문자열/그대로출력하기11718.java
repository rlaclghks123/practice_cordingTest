package 문자열;


import java.io.*;
import java.util.*;


public class 그대로출력하기11718 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {						//입력값이 존재할경우 무한 반복 
			System.out.println(sc.nextLine());		//단어가 아닌 문자열 전체를 출력 		
		}
	}
}
