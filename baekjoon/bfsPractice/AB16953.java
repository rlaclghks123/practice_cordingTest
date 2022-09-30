package bfsPractice;


import java.io.*;
import java.util.*;

public class AB16953 {

	static long n,m;
	static int cnt=0;
	
	public static void main(String[] args)throws IOException {
	Scanner sc = new Scanner(System.in);
	
	n=sc.nextLong();					//범위가 크기 때문에 long으로 받는다.
	m=sc.nextLong();
	
	System.out.println(bfs());
	
}
	public static int bfs() {
		Queue<Long> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int size = q.size();						//q의 사이즈만큼 
			for(int i=0; i<size; i++) {
				long x=q.remove();		
				
				if(x==m) {								//만약 다음수가 m일경우 
					return cnt+1;						//cnt+1해서 출력 
				}
				if(x*2<=m) {							//1번경우 : 현재수*2가 m이하 일 경우 큐에 담는다.
					q.add(x*2);
				}
				if(x*10+1<=m) {							//2번경우 : 현재수*10+1이 m이하 일 경우 큐에 담는다.
					q.add(x*10+1);
				}
			}
			cnt++;										//연결된 큐를 다 돌았으면 cnt+1해준다. 
		}
		return -1;										//그 외의값들은 m으로 갈수 없으므로 -1 출력 
	}
}