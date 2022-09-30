package bfsPractice;

import java.io.*;
import java.util.*;

public class 연구소14502 {
		
		static int dx[] =  {0,0,1,-1};
		static int dy[] = {1,-1,0,0};
		static int ans=0; 
		
		public static void main(String[] args)throws IOException {
			
			Scanner sc = new Scanner(System.in);	
			
			int n=sc.nextInt();				
			int m=sc.nextInt();
		
			int a[][] = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					a[i][j]=sc.nextInt();			//입력값을 a배열에 담아준다.
				}
			}
			
			//시간복잡도는 bfs가 O(n*m) 이므로 24 이고, 3번 반복하면 24*24*24 = > 총 시간복잡도는 13824 로 반복문을 사용해도 시간초과가 나지 않는다. 
			
			for(int x1=0; x1<n; x1++) {				//문제에서 3개를 바꿀수 있다 했으므로 3번을 반복해준다. 
				for(int y1=0; y1<m; y1++) {	
					if(a[x1][y1]!=0) continue;		//0이 아닐경우 필요없으므로 continue
					
					for(int x2=0; x2<n; x2++) {
						for(int y2=0; y2<m; y2++) {
							if(a[x2][y2]!=0) continue;
							
							for(int x3=0; x3<n; x3++) {
								for(int y3=0; y3<m; y3++) {
									if(a[x3][y3]!=0) continue;
									
									if(x1==x2 && y1==y2) continue;			//같을경우 넘겨준다.
									if(x1==x3 && y1==y3) continue;
									if(x2==x3 && y2==y3) continue;
									
									a[x1][y1]=1;						//3개를 1로 바꿔준다.
									a[x2][y2]=1;
									a[x3][y3]=1;
									
									int temp = bfs(a,n,m);				//bfs를 통해 바이러스가 옮기지 않은 부분의 최대값을 찾아준다.
									if(ans<temp) ans=temp;
									
									a[x1][y1]=0;						//원래대로 돌려준다.
									a[x2][y2]=0;
									a[x3][y3]=0;
								}
							}
						}
					}
				}
			}
			System.out.println(ans);									//최대값 출력
		}
		
		public static int bfs(int a[][], int n, int m) {
			int b[][] = new int[n][m];
			
			Queue<Integer> q = new LinkedList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					b[i][j]=a[i][j];			//배열의 요소 3개를 바꿔가면서 최대값을 찾기위해 b에 a를 복사해준다.
					if(b[i][j]==2) {
						q.add(i); q.add(j);		//bfs를 통해 바이러스를 퍼트려준다.
					}
				}
			}
			
			while(!q.isEmpty()) {
				int x=q.remove();
				int y=q.remove();
				for(int i=0; i<4; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(0<=nx && nx<n && ny>=0 && ny<m) {
						if(b[nx][ny]==0) {
							q.add(nx); q.add(ny);
							b[nx][ny]=2;
						}
					}
				}
			}
			
			int cnt=0;							//바이러스가 다 퍼진후에 0인 값의 개수를 찾아준다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(b[i][j]==0) cnt++;
				}
			}
			return cnt;
		}
}
