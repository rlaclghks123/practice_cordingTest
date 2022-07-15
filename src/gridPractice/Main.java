package gridPractice;

import java.util.*;


public class Main {
	
	static char flip(char temp) {
		if(temp=='H') {
			return 'T';
		}else {
			return 'H';
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		
		String a[] = new String[n];
		
		for(int i=0; i<n; i++) {
			a[i]=sc.next();
		}
		
		int ans=n*n;
		
		for(int col=0; col<(1<<n); col++) {
			int sum=0;
			for(int j=0; j<n; j++) {
				int cnt=0;
				for(int i=0; i<n; i++) {
					char temp = a[i].charAt(j);
					if((col&(1<<i))!=0) {
						temp=flip(temp);
					}
					if(temp=='T') {
						cnt++;
					}
				}
				sum+=Math.min(cnt, n-cnt);
			}
			if(ans>sum) ans=sum;
		}
		System.out.println(ans);
		}
}
