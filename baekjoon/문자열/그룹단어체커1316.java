package 문자열;

import java.io.*;
import java.util.*;

public class 그룹단어체커1316 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		int cnt=0;
		
		while(t-->0) {
			String s =sc.next();
			if(check(s)) {				//문자를 체크한뒤 
				cnt++;					//문제없으면 cnt++ 해준다.
			}
		}
		System.out.println(cnt);		//총개수를 출력 
	}
	
	public static boolean check(String s) {
		int prev=0;								//이전값을 담기위한 변수 
		boolean c[] = new boolean[26];			//방문 체크를 위한 배열 
		
		for(int i=0; i<s.length(); i++) {
			int now = s.charAt(i);				//현재값 
			
			if(prev!=now) {						//이전값과 현재값이 다르다면 
				if(!c[now-'a']) {				//방문했는지 확인 후 방문한적 없다면  
					c[now-'a'] = true;			//방문처리 
					prev=now;					//현재값을 이전값으로 설정 
				}
				else {							//이전값과 현재값이 다르면서, 방문했다면 	
					return false;				//거짓 
				}
			}else {								//이전값과 현재값이 같다면 
				continue;						//넘겨준다.
			}
		}
		return true;
	}
}