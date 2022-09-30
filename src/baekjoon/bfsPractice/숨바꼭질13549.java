package bfsPractice;

import java.io.*;
import java.util.*;

public class 숨바꼭질13549 {
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int max=1000000;				//최대값 지정 
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		boolean c[] = new boolean[max+1];	//방문처리 
		int d[] = new int[max+1];			//동생 찾는 시간을 담을 배열 
		
		// bfs는 가중치가 1인 경우만 사용
		//덱을 사용하거나, 큐를 두개 해서 사용 : 가중치가 0,1이라, q에는 가중치가 0인경우 담고, q2에는 가중치가 1인 경우 담기 
		
		//큐 사용 
//		Queue<Integer> q = new LinkedList<>();
//		Queue<Integer> q2 = new LinkedList<>();
//		
//		q.add(n);
//		c[n]=true;
//		
//		while(!q.isEmpty()) {
//			int now=q.remove();
//			for(int next:new int[] {now-1, now+1, now*2}) {
//				if(0<=next && next<=max) {
//				if(!c[next]) {
//					c[next]=true;
//					
//					if(next==now*2) {
//						q.add(next);
//						d[next]=d[now];
//					}else {
//						q2.add(next);
//						d[next]=d[now]+1;
//					}
//				}
//				}
//			}
//			
//			if(q.isEmpty()) {
//				q=q2;
//				q2=new LinkedList<>();
//			}
//		}
		
		//덱 사용 
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		deq.add(n);
		c[n]=true;
		
		while(!deq.isEmpty()) {
			int now=deq.remove();
			for(int next:new int[] {now-1, now+1, now*2}) {
				if(0<=next && next<max) {
					if(!c[next]) {
						c[next]=true;
						if(next==now*2) {
							deq.addFirst(next);
							d[next]=d[now];
						}else {
							deq.addLast(next);
							d[next]=d[now]+1;
						}
					}
				}
			}
		}
		System.out.println(d[m]);	
	}
}
