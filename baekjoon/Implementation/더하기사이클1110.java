package Implementation;

import java.io.*;
import java.util.*;

public class 더하기사이클1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
        
		int cnt = 0;		//count할 변수 	
		int temp = n;		//값을 복제해준다.
        
		while(true) {
			int left = temp / 10;    //10이 자리수이므로 /10 
			int right = temp % 10;	//1의 자리수 이므로 %10
			temp = right * 10 + (left + right) % 10;    //1의자리수는 10의자리로 두개 합한 숫자는 1의자리로 이동 
			cnt++;			//count해준다.
			if(n == temp) {		//만약 사이클의 숫자와 입력된값의 숫자가 같을경우 멈춰준다.
				break;
			}
		}
		System.out.println(cnt);	//총 count값
	}
}
