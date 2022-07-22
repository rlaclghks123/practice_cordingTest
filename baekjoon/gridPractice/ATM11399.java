package gridPractice;

import java.util.*;

public class ATM11399 {
	
	//기준 : 돈을 출금하는데 적게 걸리는 사람부터 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		
		int ans=0;
		int sum=0;
		
		Arrays.sort(a);					//돈 출금하는데 적게 걸리기위해 정렬 오름차순  
		
		for(int i=0; i<n; i++) {		//각각의 사람마다 걸리는 시간 
			sum+=a[i];					//총 걸리는 시간 
			ans+=sum;
		}
		
		System.out.println(ans);
	}

}
