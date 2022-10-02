package 문자열;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		int cnt=0;
		
		while(t-->0) {
			String s = sc.next();
			if(check(s)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean check(String s) {
		
		int prev=0;
		boolean c [] = new boolean[26];
		
		for(int i=0; i<s.length(); i++) {
			int now=s.charAt(i);
				if(prev!=now) {
					if(!c[now-'a']) {
					c[now-'a']=true;
					prev=now;
				}else {
					return false;
				}
			}else {
				continue;
			}
		}
		return true;
	}
}

//65~90