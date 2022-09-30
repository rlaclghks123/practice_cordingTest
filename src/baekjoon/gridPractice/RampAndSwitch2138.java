package gridPractice;

import java.util.*;


class Pair{					   
	boolean first;		//first : A와B가 같은지 확인하는 boolean,
	int second;			//second : A와 B가 같은경우 스위치를 누르는 횟수 
	Pair(boolean first, int second){
		this.first=first;
		this.second=second;
	}
}


public class RampAndSwitch2138 {

	static void change(int a[], int index) {		//좌,본인,우 스위치를 봐꿔주는 함수 
		for(int i=index-1; i<=index+1; i++) {
			if(0<=i && i<a.length) {
				a[i]=1-a[i];
			}
		}
	}
	
	static Pair go(int a[], int goal[]) {			//원하는 전구로 만들기위해 확인하는 함수 
		int n=a.length;
		int ans=0;
		
		for(int i=0; i<n-1; i++) {					//마지막은 빼고 찾아서,다를경우 스위치를 눌러 바꿔준다.  
			if(a[i]!=goal[i]) {
				change(a,i+1);
				ans++;
			}
		}
		boolean ok =true;							//A와B가 같은지 확인 
		for(int i=0; i<n; i++) {					//전부 확인한다.
			if(a[i]!=goal[i]) {
				ok=false;							//불가능할경우 false 리턴 
			}
		}
		
		if(ok) {									//가능하다면 	
			return new Pair(true,ans);				//true(가능), ans(횟수)을 리턴 
		}else {										//불가능 하다면 
			return new Pair(false,ans);				//false(불가능), ans(횟수)을 리턴 ans대신 아무거나 와도됨 
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
		
		s = sc.next();
		for(int i=0; i<n; i++) {
			goal[i]=s.charAt(i)-'0';
		}
		
		int b[] = new int[a.length];				// 스위치를 안누르는 경우를 대입하기 위해 b를 생성 
		System.arraycopy(a, 0, b, 0, a.length);		// b에게 a를 복사해준다. 
		
		//첫번째 스위치를 안누르는 경우
		Pair p1=go(b,goal);							//되는지 안되는지 판별							 
		
		//첫번째 스위치를 누르는 경우
		change(a,0);								//첫번째 스위치를 눌러준다.  
		Pair p2=go(a,goal);							//되는지 안되는지 판별 
		if(p2.first) {								//가능하다면 
			p2.second++;							//사이즈 +1  이유는 change(a,0) 을 한번 누른것 이기 때문
		}
		
		if(p1.first && p2.first) {					//둘다되면 
			System.out.println(Math.min(p1.second, p2.second));	//최소값 찾기 
		}else if(p1.first) {						//p1만 되면(첫번째 스위치 안누른경우) 
			System.out.println(p1.second);		
		}else if(p2.first) {						//p2만 되면(첫번째 스위치 누른경우)
			System.out.println(p2.second);
		}else {
			System.out.println(-1);					//아예안되면 -1 출력
		}
	}
}
