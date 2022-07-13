package bfsPractice;

import java.util.*;

public class sosu_path1963 {

	// num:기존 비밀번호,    index: 바꿀 비밀번호의 index위치 ,  digit:바꿀 숫자 
	static int change(int num, int index, int digit) {	//비밀번호의 숫자를 바꾸는 함수 	
		if(index==0 && digit==0) {						//문제에서 4자리숫자 이므로 맨앞자리가 0이면 안된다. 0123 = 3자리  
			return -1;
		}
		
		String s = Integer.toString(num);				//기존 비밀번호를 문자열로 바꿈 
		StringBuilder sb = new StringBuilder(s);		// stringBuilder에 기존 s를 넣어줌 
		sb.setCharAt(index, (char)(digit+'0'));			//index번째 숫자를 바꿔 문자로 바꾼다.
		return Integer.parseInt(sb.toString());			//문자열로 변환한뒤, 숫자로 바꿔서 return  
	}
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);	
	
	boolean prime[] = new boolean[10001];				//소수찾는 배열 
	
	for(int i=2; i<=10000; i++) {						//에라토스네의체 
		if(prime[i]==false) {
			for(int j=i+i; j<=10000; j+=i) {
				prime[j]=true;
			}
		}
	}
	
	
	int t=sc.nextInt();				
	while(t-->0) {
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		boolean c[] = new boolean[10001];
		int d[] = new int[10001];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		c[n]=true;
		
		while(!q.isEmpty()) {
			int now=q.remove();
			for(int i=0; i<4; i++) {
				for(int j=0; j<=9; j++) {
					int next=change(now,i,j);
					if(next!=-1) {						//4자리가 가능하다면 
						if(!prime[next] && c[next]==false) {		//소수 이면서 && 방문한적이 없을경우 
							q.add(next);
							c[next]=true;
							d[next]=d[now]+1;					//횟수 추가 
						}
					}
				}
			}	
		}
		if(d[m]==-1) {
			System.out.println("Impossible");		//불가능한 경우 Impossible 출력 
		}else {
			System.out.println(d[m]);				//가능하다면 d[m] 최소값 출력 			
		}
	}
	}

}
