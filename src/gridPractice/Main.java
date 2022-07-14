package gridPractice;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		
		
		int ans=0;
		int sum=0;
		Arrays.sort(a,0,n);
		
		for(int i=0; i<n; i++) {
				sum+=a[i];
				ans+=sum;
		}
		
		System.out.println(ans);
		}
}
