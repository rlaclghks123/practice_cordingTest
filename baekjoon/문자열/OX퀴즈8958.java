package 문자열;
import java.io.*;
import java.util.*;


public class OX퀴즈8958 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0) {
			int cnt=0;							//O의 개수를 측정 
			int sum=0;							//총 합을 구할 변수 
			String s[] = sc.next().split("");	//""를 기준으로 배열에 담는다.
			for(int i=0; i<s.length; i++) {
				if(s[i].charAt(0)=='O') {		// O일 경우 
					cnt++;						//개수 ++ 	
					sum+=cnt;					//총합에 cnt값을 더해준다.
				}
				if(s[i].charAt(0)=='X') {		// X일 경우 
					cnt=0;						//개수는 0개 
					sum+=cnt;					//총 합에 더해준다.
				}
			}
			System.out.println(sum);			//출력 
		}
	}
}

