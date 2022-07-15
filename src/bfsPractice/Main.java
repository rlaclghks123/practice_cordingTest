package bfsPractice;

import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	Meeting(int start, int end){
		this.start=start;
		this.end=end;
	}
	public int compareTo(Meeting That) {
		if(this.end<That.end) {
			return -1;
		}else if(this.end==That.end) {
			if(this.start<That.start) {
				return -1;
			}else if(this.start==That.start) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}
}


public class Main {
	
	static long limit = 1000000000L;
	
	public static void main(String[] args)throws IOException {
    	
	Scanner sc = new Scanner(System.in);	
	
	int n=sc.nextInt();
	
	Meeting a[] = new Meeting[n];
	
	for(int i=0; i<n; i++) {
		int start=sc.nextInt();
		int end=sc.nextInt();
		a[i]=new Meeting(start,end);
	}
	
	Arrays.sort(a);
	
	int last=-1;
	int ans=0;
	for(int i=0; i<n; i++) {
		if(last<=a[i].start) {
			last=a[i].end;
			ans++;
		}
	}
	System.out.println(ans);
   }
}


//

