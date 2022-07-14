package gridPractice;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}

		int cnt=0;
		for(int i=n-1; i>=0; i--) {
			cnt+=m/a[i];
			m=m%a[i];
		}
		System.out.println(cnt);
	}
}
