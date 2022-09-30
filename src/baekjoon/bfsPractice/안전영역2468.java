package bfsPractice;

import java.io.*;
import java.util.*;


public class 안전영역2468 {
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static int max=101;				//최대값 
	static int map[][]=new int[max][max];		//map배열은 바뀌지 않기때문에 전역으로 사용
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);	
		
		int n=sc.nextInt();
		
		//map의 값을 채워준다.
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();		//
			}
		}
		
		int ans=0;
		//물의 높이를 0부터 max까지 돌면서 잠기지 않은곳을 찾아준다. (잠기지 않을경우가 있기 때문에 0부터)
		for(int h=0; h<max; h++) {			//max를 101로 잡았기 때문에 이하(<=) 가 아닌 미만으로 해준다(<)
			int temp =bfs(n,h);
			if(ans<temp) ans=temp;			//최대값을 찾아준다.
		}
		
		System.out.println(ans);
	}
	
	public static int bfs(int n,int h) {
		int d[][] = new int[max][max];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				d[i][j]=-1;
			}
		}
		
		//h만큼의 높이 이하인 지역을 잠기도록 해준다.(0으로 설정) 
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]<=h && d[i][j]==-1) {
					q.add(i); q.add(j);
					d[i][j]=0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			
			for(int i=0; i<4; i++) {
				int ny=y+dy[i];
				int nx=x+dx[i];
				if(0<=nx && nx<max && ny>=0 && ny<max) {
					if(map[nx][ny]<=h && d[nx][ny]==-1) {
						q.add(nx); q.add(ny); 
						d[nx][ny]=0;
					}
				}
			}
		}
		
		int cnt=0;		//안전한 영역의 개수를 담을 변수 
		//물에 잠기지 않은 지역들을 묶어서 안전한 영역의 개수를 찾아준다.
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]>h && d[i][j]==-1) {
					cnt++;
					q.add(i); q.add(j);
					d[i][j]=cnt;
					
					while(!q.isEmpty()) {
						int x=q.remove();
						int y=q.remove();
						
						for(int k=0; k<4; k++) {
							int ny=y+dy[k];
							int nx=x+dx[k];
							if(0<=nx && nx<max && ny>=0 && ny<max) {
								if(map[nx][ny]>h && d[nx][ny]==-1) {
									q.add(nx); q.add(ny); 
									d[nx][ny]=cnt;
								}
							}
						}
					}
				}
			}
		}
		
		
		return cnt;
	}
}