package bfsPractice;

import java.io.*;
import java.util.*;




public class Main {
	
	static long limit = 1000000000L;
	
	public static void main(String[] args)throws IOException {
    	
	Scanner sc = new Scanner(System.in);	
	
	
	long a =sc.nextLong();
	long b=sc.nextLong();
	
	Queue<Long> q = new LinkedList<Long>();
    Queue<String> qs = new LinkedList<String>();
    HashSet<Long> check = new HashSet<Long>();
    q.add(a);
    qs.add("");
    check.add(a);
	
	while(!q.isEmpty()) {
		long x=q.remove();
		String str=qs.remove();
		
		if(x==b) {
			if(str.length()==0) {
				str="0";
			}
			System.out.println(str);
			System.exit(0);
		}
		if(0<=x*x && x*x<=limit && check.contains(x*x)==false) {
			q.add(x*x);
			qs.add(str+"*");
			check.add(x*x);
		}
		if(0<=x+x && x+x<=limit && check.contains(x+x)==false) {
			q.add(x+x);
			qs.add(str+"+");
			check.add(x+x);
		}
		if(0<=x-x && x-x<=limit && check.contains(x-x)==false) {
			q.add(x-x);
			qs.add(str+"-");
			check.add(x-x);
		}
		if(x!=0 && 0<=x/x && x/x<=limit && check.contains(x/x)==false) {
			q.add(x/x);
			qs.add(str+"/");
			check.add(x/x);
		}
	}
	System.out.println(-1);
	
   }
}


//

