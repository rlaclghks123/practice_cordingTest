package bfsPractice;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class escape_movig_miro {

	static int dx[] = {1,-1,0,0,1,1,-1,-1,0};	//상하좌우,대각,제자리 
	static int dy[] = {0,0,1,-1,1,-1,1,-1,0};
	static int n=8;								//8*8 보드판이기 때문 
	
	public static void main(String[] args)throws IOException {
    	
	Scanner sc = new Scanner(System.in);	
	
	String s[] = new String[n];
	boolean ans=false;							//0,7까지 갈수 있는지 판단하기 위해 
	boolean c[][][] = new boolean [8][8][9];	//방문 했는지 파악하기 위해(중복방지) 
	
	for(int i=0; i<n; i++) {
		s[i]=sc.next();
	}
	
	Queue<Integer> q = new LinkedList<>();
	q.add(7); q.add(0); q.add(0);				//문제에서 왼쪽 맨밑에서 시작 
	c[7][0][0]=true;							//방문처리 
	
	while(!q.isEmpty()) {
		int x=q.remove();						// x,y는 좌표      t는 시간  
		int y=q.remove();
		int t=q.remove();
		
		if(x==0 && y==7) ans=true;				//0,7로 도착하면 성공! 
		
		for(int i=0; i<9; i++) {				
			int nx=x+dx[i];
			int ny=y+dy[i];
			int nt=Math.min(t+1, 8);			//8초후면 벽이 다 없어지므로 
			if(0<=nx && nx<n && ny>=0 && ny<n) {
				if(nx-t>=0 && s[nx-t].charAt(ny)=='#') continue;		//현재값이 벽일 경우 패스 
				if(nx-t-1>=0 && s[nx-t-1].charAt(ny)=='#') continue;	//다음값이(현재위치보다 한칸 위) 벽일 경우 패스 
				if(c[nx][ny][nt]==false) {					//방문하지 않았다면 
					c[nx][ny][nt]=true;						//방문처리 
					q.add(nx); q.add(ny); q.add(nt);		//다음 방문 
				}
			}
		}
	}
	System.out.println(ans ? 1 : 0);					//ans를 통해 성공시 1 실패시 0 출
   }
}
