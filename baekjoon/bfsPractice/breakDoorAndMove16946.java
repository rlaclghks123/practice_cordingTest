package bfsPractice;

import java.io.*;
import java.util.*;

//인접한 모든곳을 방문하기 때문에 bfs 사용.
public class breakDoorAndMove16946 {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static boolean c[][];		//방문처리를 위함 
	static int group[][];		//0인부분 group짓기 위함 
	static int a[][];			//입력값 
	static int n,m;
	
	static ArrayList<Integer> group_size = new ArrayList<>();	//그룹의 크기를 위해 . 계속변하기 때문에 ArrayList사용 
	
	static void bfs(int sx, int sy) {
	
		int g = group_size.size();			//group의 크기를 g에 담아준다.
		int cnt=1;							//처음은 1부터 sx,sy를 포함하기 때문  
		
		Queue<Integer> q = new LinkedList<>();
		q.add(sx); q.add(sy);
		c[sx][sy]=true;					//방문처리 
		group[sx][sy]=g;				//현재 그룹에 그룹크기를 넣어준다.
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(a[nx][ny]==0 && c[nx][ny]==false) {	//0이면서 방문한적 없다면 
						q.add(nx); q.add(ny);				
						c[nx][ny]=true;						//방문처리 
						group[nx][ny]=g;					//그룹크기를 담아주고 
						cnt++;								//크기를 늘려준다.
					}
				}
			}	
		}
		group_size.add(cnt);								//그룹크기 변경 
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s[] = br.readLine().split(" ");
		
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
		
		group= new int[n][m];
		c= new boolean[n][m];
		a = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				a[i][j]=str.charAt(j)-'0';
				c[i][j]=false;
				group[i][j]=-1;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==0 && c[i][j]==false) {			//0이면서 방문한적이 없다면 bfs로 그룹을 찾아줌 
					bfs(i,j);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==0) {							
					bw.write("0");
				}else {
					 HashSet<Integer> near = new HashSet<>();			//중복을 없애기위해 HashSet 사용 
					 for(int k=0; k<4; k++) {
						 int nx=i+dx[k];
						 int ny=j+dy[k];
						 if(0<=nx && nx<n && ny>=0 && ny<m) {
							 if(a[nx][ny]==0) {
								 near.add(group[nx][ny]);				//그룹을 추가해준다.
							 }
						 }
					 }
					 int ans=1;
					 for(int g:near) {		
						 ans+=group_size.get(g);				//찾은 그룹의 크기를 담아준다.
					 }
					 bw.write(String.valueOf(ans%10));
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}

}
