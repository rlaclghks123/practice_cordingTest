package bfsPractice;

import java.util.*;

public class 숨바꼭질1697 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		int n=sc.nextInt();			//수빈이 위치 
		int k=sc.nextInt();			//동생의 위치
		int max=100001;				//최대값
		
		int d[] = new int[max];				//수빈이를 찾는데 걸리는 시간을 담을 배열 
		boolean c[] = new boolean[max];		//방문처리를 위한 배열 
		
		Queue<Integer> q = new LinkedList<>();	//1초 걸리기(가중치1) 때문에 bfs로 처리 가능 	
		q.add(n);
		c[n]=true;							//방문처리 
		
		while(!q.isEmpty()) {
			int now=q.remove();
			
			//배열안에 넣어서 for문 사용시 
			for(int next:new int[] {now-1, now+1, now*2}) {			//3가지 경우를 배열안에 넣어서 for문으로 돌면서 하나씩 꺼낸다.
				if(next>=0 && next<max) {							//범위 안에 있다면 
					if(c[next]==false) {							//방문하지 않았다면 
						c[next]=true;								//방문처리 
						q.add(next);								
						d[next]=d[now]+1;							//1초 추가 
					}
				}
			}
			

			//if문 사용시												//3가지 밖에 안되기떄문에 if문을 통해 모든 경우의수를 구해준다.
			
//			if(now-1>=0) {											//-1 하는 경우 
//				if(c[now-1]==false) {
//					c[now-1]=true;
//					q.add(now-1);
//					d[now-1]=d[now]+1;
//				}
//			}
//			
//			if(now+1<max) {											//+1하는 경우 
//				if(c[now+1]==false) {
//					c[now+1]=true;
//					q.add(now+1);
//					d[now+1]=d[now]+1;
//				}
//			}
//			
//			if(now*2<max) {											//*2 (순간이동) 하는 경우
//				if(c[now*2]==false) {
//					c[now*2]=true;
//					q.add(now*2);
//					d[now*2]=d[now]+1;
//				}
//			}
		}
		System.out.println(d[k]);									//동생의 위치일경우 값을 출력한다.
	}

}
