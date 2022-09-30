package Implementation;

import java.util.Scanner;

public class groupWordChecker {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int n=sc.nextInt();
	int cnt=0; //연속하는 문자의 개수를 담을 변수
	
	
	//입력된 횟수만큼 반복해준다.
	for(int i=0; i<n; i++) {
		String str = sc.next();
		
		//입력된 문자열에 대해  연속하는 문자인지 확인한다.
		if(check(str)) {
			cnt++;
		}
	}
	System.out.println(cnt);   //총 연속된 문자 개수를 출력해준다.	
	}
	
	public static boolean check(String str) {
		int n=str.length();
		boolean c[] = new boolean[26];
		int prev=0;
		
		for(int i=0; i<n; i++) {		//문자열의 문자를 모두 확인한다.
			int now = str.charAt(i);
			
			if(prev!=now) {					//이전값과 다를경우 	
				if(c[now-'a']==false) {		//방문한적 없다면 
					c[now-'a']=true;		//방문처리 
					prev=now;				//이전값을 현재값으로 바꿔준다.
				}else {
					return false;				//방문한적 있으면
				}
			}else {						//이전값과 같을경
				continue;
			}
		}
		return true;
	}
}
