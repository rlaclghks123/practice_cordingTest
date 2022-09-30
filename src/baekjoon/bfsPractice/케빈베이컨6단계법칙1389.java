package bfsPractice;


import java.io.*;
import java.util.*;

public class 케빈베이컨6단계법칙1389 {
	
	static ArrayList<Integer> list[];
	static boolean c[];

	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		list = new ArrayList[n+1];
		c = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=1; i<=m; i++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		
		go(n);
}
	public static void go(int n) {
		
		int minCnt = Integer.MAX_VALUE;		//최소값을 구하기 위해 처음 값을 최대값으로 지정 
		int minIndex = 0;
		
		for(int i=1; i<=n; i++) {	
				int temp = bfs(i,n);		
				if(minCnt>temp){			//최소 카운트 될때 
					minCnt=temp;
					minIndex=i;				//그때의 index값을 구해준다.
				}
			
		}
		System.out.println(minIndex);
	}
	
	public static int bfs(int i, int n) {
		int d[] = new int[n+1];
		Arrays.fill(d, -1);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		int cnt=0;
		
		while(!q.isEmpty()) {
			int x=q.remove();
			for(int y:list[x]) {
				if(d[y]==-1) {
					d[y]=d[x]+1;
					cnt+=d[y];			//총 count값을 더해준다.
					q.add(y);
				}
			}
		}
		return cnt;
	}
}