package gridPractice;

import java.util.*;


public class Main {
	
	static void change(int a[], int index) {
		for(int i=index-1; i<=index+1; i++) {
			if(i>=0 && i<a.length) {
				a[i]=1-a[i];
			}
		}
	}
	
	static Pair go(int a[], int [] goal) {
		int n=a.length;
		int ans=0;
		
		for(int i=0; i<n-1; i++) {
			if(a[i]!=goal[i]) {
				ans++;
				change(a,i+1);
			}
		}
		
		boolean ok=true;
		for(int i=0; i<n; i++) {
			if(a[i]!=goal[i]) {
				ok=false;
			}
		}
		if(ok) {
			return new Pair(true,ans);
		}else {
			return new Pair(false,ans);
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		
		int a[] = new int[n];
		int goal[] = new int[n];
		
		String s = sc.next();
		for(int i=0; i<n; i++) {
			a[i]=s.charAt(i)-'0';
		}
		
		s=sc.next();
		for(int i=0; i<n; i++) {
			goal[i]=s.charAt(i)-'0';
		}
		
		int b[] = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		
		Pair p1=go(b,goal);
		
		change(a,0);
		Pair p2=go(a,goal);
		
		if(p2.first) {
			p2.second++;
		}
		
		if(p1.first && p2.first) {
			System.out.println(Math.min(p2.second, p1.second));
		}else if(p1.first) {
			System.out.println(p1.second);
		}
		else if(p2.first) {
			System.out.println(p2.second);
		}else {
			System.out.println(-1);
		}
		}
}
