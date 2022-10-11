package 문자열;

import java.io.*;
import java.util.*;

public class KMP는왜KMP일까2902 {
	 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();							//정답을 담기 위해 작성해준다.
		StringTokenizer st = new StringTokenizer(sc.nextLine(),"-");	// - 를 기준으로 나눠준다. 
		
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken().charAt(0));						//-를 기준으로 나누것중 제일 첫번째를 sb에 담아준다.
		}
		System.out.println(sb);			//출력해준다.
	}
}
