package bfsPractice;

import java.io.*;
import java.util.*;

public class DSLR9019 {


	static int max=10001;
	
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			
			boolean c[] = new boolean[max]; //방문처리 
			int from[] = new int[max];      //이전값을 가져오기 위함 
			char how[] = new char[max]; 	//이전값의 문자 
			
			Queue<Integer> q = new LinkedList<>();
			q.add(s);
			c[s]=true;						//방문처리 
			from[s]=-1;						//처음의 이전값은 없으므로 -1 
			
			while(!q.isEmpty()) {
				int now=q.remove();
				
				// 1. D의 경우
				int next=now*2;
				if(next>9999) next %=10000;
				
				if(!c[next]) {
					q.add(next);
					c[next]=true;
					from[next]=now;
					how[next]='D';
				}
				
				// 2. S의 경우
				next=now-1;
				if(next==-1) next=9999;
				
				if(!c[next]) {
					q.add(next);
					c[next]=true;
					from[next]=now;
					how[next]='S';
				}
				
				// 3. L의 경우    1234 -> 2341 
				next = (now%1000) *10+ (now/1000);
				
				if(!c[next]) {
					q.add(next);
					c[next]=true;
					from[next]=now;
					how[next]='L';
				}
				
				// 4. R의 경우    1234 -> 4123 
				next = (now/10) + (now%10)*1000; 
				
				if(!c[next]) {
					q.add(next);
					c[next]=true;
					from[next]=now;
					how[next]='R';
				}
			}
		
			StringBuilder sb = new StringBuilder();
			
			while(e!=s) {						//시작값과 끝값이 같지 않다면 
				sb.append(how[e]);				//문자를 넣어준다.
				e=from[e];						//끝값을 이전값으로 바꿔준다. 
			}
			System.out.println(sb.reverse());	//값을 끝에서 부터 저장했으므로 reverse를 통해 뒤집어서 출력해준다.
		}
	}
}