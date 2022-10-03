package 문자열;


import java.io.*;
import java.util.*;

public class 열개씩끊어서출력하기11721 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s  =sc.nextLine();					//문자열을 입력받는다.
		
		for(int i=0; i<s.length(); i++) {
			if(i%10==9) {							//9번째마다 출력후 한줄 띄어준다.
				System.out.print(s.charAt(i));
				System.out.println();
			}else {
				System.out.print(s.charAt(i));
			}
		}
	}
}

