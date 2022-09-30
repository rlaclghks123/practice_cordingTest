package bfsPractice;

import java.io.*;
import java.util.*;


public class 스타트링크5014 {
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int f=sc.nextInt();				//총 층수 
		int s=sc.nextInt();				//현재 시작층수 
		int g=sc.nextInt();				//목적지 층수 
		int u=sc.nextInt();				//올라가는 층수 
		int d=sc.nextInt();				//내려가는 층수 
				
		int c[] = new int[f+1];
		
		System.out.println(bfs(f,s,g,u,d,c));
	}
	
	//안될경우 String형식으로 출력 해야하므로 string 형식으로 지정해준다.
	public static String bfs(int floor, int start, int end, int up, int down, int c[]) {
		
		Queue<Integer> q = new LinkedList<>();		//시작점을 큐에 넣는다.
		q.add(start);
		c[start]=1;
		
		while(!q.isEmpty()) {
			int now=q.remove();
			
			if(now==end) {			//목적지에 도달했다면 
				return String.valueOf(c[now]-1);		//정답을 String 형식으로 출력 , 처음을 1로 시작했으므로 1을 빼준다. 
			}
			
			//올라갈 경우 최대층수 이하일 경우 가능  
			if(now+up<=floor) {
				if(c[now+up]==0) {		//방문한적없다면 
					q.add(now+up);		
					c[now+up] = c[now]+1;		//횟수 추가 
				}
			}
			
			//내려갈 경우 1층 이상일경우 가능
			if(now-down>=1) {
				if(c[now-down]==0) {			//방문한적 없다면 
					q.add(now-down);
					c[now-down]=c[now]+1;		//횟수 추가 
				}
			}
		}
		return "use the stairs";
	}
}
