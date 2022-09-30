package bfsPractice;
import java.io.*;
import java.util.*;

class Pair16234{					//pair 클래스를 사용
	int x,y;
	public Pair16234(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class 인구이동16234 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int n,l,r,cnt;	
	static int map[][];
	static boolean check[][];									//방문처리를 위한 배열 
	static boolean isOk=false;									//국경을 넘을수 있는지 확인하는 변수 
	static ArrayList<Pair16234> arr = new ArrayList<>();		//차이가 범위 내에 들어있는 index번호를 담을 배열 
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		l=sc.nextInt();
		r=sc.nextInt();
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();			
			}
		}
		
		go();
		System.out.println(cnt);
	}
	
	public static void go() {
		while(true) {
			isOk=false;							//bfs시작할때 마다 초기화  									
			check = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!check[i][j]) {			//방문한적 없다면 						
						bfs(i,j);				//bfs 처리 
					}
				}
			}
			if(!isOk) break;					//국경선을 방문할수없으면 반복문 종료 			
			else cnt++;							//국경이동이 있다면 일수 추가  
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair16234> q = new LinkedList<>();			
		q.add(new Pair16234(x,y));
		check[x][y]=true;
		arr.add(new Pair16234(x,y));
		
		
		while(!q.isEmpty()) {
			Pair16234 p = q.remove();
			x=p.x;
			y=p.y;
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<n) {
					//방문한적없으면서, 차이가 범위 내에 있다면 
					if(!check[nx][ny] && l<=Math.abs(map[x][y]-map[nx][ny]) && Math.abs(map[x][y]-map[nx][ny])<=r) {
						isOk=true;
						check[nx][ny]=true;
						q.add(new Pair16234(nx,ny));
						arr.add(new Pair16234(nx,ny));
					}
				}
			}
		}
		int sum=0;
		for(int i=0; i<arr.size(); i++) {
			Pair16234 p = arr.get(i);
			sum+=map[p.x][p.y];						//총 더한 값을 담아주고 
		}
		
		for(int i=0; i<arr.size(); i++) {
			Pair16234 p = arr.get(i);
			map[p.x][p.y] = sum/arr.size();			//평균값을 담아준다. 
		}
		arr.removeAll(arr);
	}
}
