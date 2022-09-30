package gridPractice;

import java.util.*;

public class Coin11047 {
	// 동전의 가격이 배수 관계 이므로 가격이 높은순으로 / , % 로 사용가능  
	// 기준 : 가격이 높은거에 따라 나눔 (배수관계) 
																												public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int a[] = new int[n];			//동전가격을 담을 배열 
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		
		int cnt=0;
		for(int i=n-1; i>=0; i--) {		//큰가격 먼저 거슬러주기 위해 n-1부터 0까지 반복 
			cnt+=m/a[i];				//개수를 /로 나타낸다.
			m=m%a[i];					//남은돈을 %로 나타낸다.
		}
		System.out.println(cnt);
		
		
	}

}
