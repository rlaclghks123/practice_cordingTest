package 문자열;

import java.io.*;
import java.util.*;

public class 소트인사이드1427 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();	//숫자를 담을 ArrayList 생성 
		
		String s =sc.next(); 						//문자열을 입력받는다.
		
		for(int i=0; i<s.length(); i++) {
			arr.add(s.charAt(i)-'0');  				//문자열에서 문자를 하나씩 뽑아 숫자로 바꿔 ArrayList에 담아준다.
		}
		
		Collections.sort(arr, Comparator.reverseOrder()); 		//ArrayList를 내림차순으로 정렬해준다.
		
		for(int ans:arr) {
			System.out.print(ans);   							//ArrayList에서 값을 하나씩 가져와 출력해준다.
		}
	}
}
