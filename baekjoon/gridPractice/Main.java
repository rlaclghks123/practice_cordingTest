package gridPractice;

import java.io.*;
import java.util.*;

class Jewel implements Comparable<Jewel>{
	int m;
	int v;
	int w;
	Jewel(int m, int v, int w){
		this.m=m;
		this.v=v;
		this.w=w;
	}
	public int compareTo(Jewel That){
		return 1;
	}
}
public class Main {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
    public static void main(String args[]) throws IOException {
   
    	Scanner sc  = new Scanner(System.in);
    	
    	int n=sc.nextInt();
    	int k=sc.nextInt();
    	
    	Jewel a[] = new Jewel[n];
    	
    	for(int i=0; i<n; i++) {
    		int m=sc.nextInt();
    		int v=sc.nextInt();
    		a[i]=new Jewel(m,v,0);
    	}
    	
    	for(int i=0; i<k; i++) {
    		int m=sc.nextInt();
    		a[n+i] = new Jewel(m,0,1);
    	}
    	
    	Arrays.sort(a);
    	
    }
}
