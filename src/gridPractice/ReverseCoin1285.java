package gridPractice;

import java.util.*;


public class ReverseCoin1285 {

	static char flip(char temp) {		//문자가 H => T, T=>H로 바꾸는 함수 
		if(temp=='T') {
			return 'H';
		}else {
			return 'T';
		}
	}
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n=sc.nextInt();
	
	String a[] = new String[n];
	
	for(int i=0; i<n; i++) {
		a[i]=sc.next();
	}
	
	int ans=n*n;							//최소값을 구하기 위해 처음엔 최대값을 넣어준다.
	
	for(int col=0; col<(1<<n); col++) {		//비트마스크를 이용해주며 행을 바꿀지 말지 결정 
		int sum=0;							//총 T의 개수를 구하기 위함 
		for(int j=0; j<n; j++) {			//열에 대해 탐색한다. 
			int cnt=0;						//각 열에대한 T의 개수 
			for(int i=0; i<n; i++) {		//j열의 i행에 대해 탐색한다.
				char temp = a[i].charAt(j);	 
				
				if((col & (1<<i))!=0) {		//i행을 뒤집었다면  
					temp=flip(temp);		// 
				}
				
				if(temp=='T') {				//만약 T라면 
					cnt++;					//개수추가 
				}
			}
			sum+=Math.min(cnt, n-cnt);		// 최소값을 찾아주고  
		}
		if(ans>sum) ans=sum;				//전체적으로 최소값을 찾아준다. 
	}
	System.out.println(ans);				//최종 최소값을 출력
	}

}
