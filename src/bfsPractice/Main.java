package bfsPractice;

import java.io.*;
import java.util.*;




public class Main {
	
	static int change(int num, int index, int digit) {
		if(index==0 && digit==0) {
			return -1;
		}
		
		String s = Integer.toString(num);
		StringBuilder sb = new StringBuilder(s);
		
		sb.setCharAt(index, (char)(digit+'0'));
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args)throws IOException {
    	
	Scanner sc = new Scanner(System.in);	
	
	int t=sc.nextInt();
	
	boolean prime[] = new boolean[10001];
	
	for(int i=2; i<=10000; i++) {
		if(prime[i]==false) {
			for(int j=i*i; j<=10000; j+=i) {
				prime[j]=true;
			}
		}
	}
	
	for(int i=0; i<=10000; i++) {
		prime[i]=!prime[i];
	}
	
	while(t-->0) {
		int n=sc.nextInt();
		int m=sc.nextInt();
	
		boolean c[] = new boolean[10001];
		int d[] = new int[10001];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		c[n]=true;
		d[n]=0;
		
		while(!q.isEmpty()) {
			int x=q.remove();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<=9; j++) {
					int next=change(x,i,j);
					if(next!=-1) {
						if(prime[next] && c[next]==false) {
							q.add(next);
							d[next]=d[x]+1;
							c[next]=true;
						}
						
					}
				}
		}
		}
		System.out.println(d[m]);
	}
	
   }
}


//

