package bfsPractice;

import java.util.*;

// 적록색약이 아닐 경우, RGB 각각 그룹을 만들고, 적록색약일 경우 R,G는 같은 그룹으로 만들어준다.
//한 정점에서 이어지는 정점을 묶기때문에 BFS사용 

public class Red_green_medicine10026 {

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};

	//그룹을 지을수 있는지 확인하는 함수이며, 적록색약일경우 이전값과 다음값이 R,G일 경우도 추가해준다.
	static boolean can(boolean blind, char from, char to) {	
		if(from==to) return true;
		if(blind) {
			if(from=='R' && to=='G') return true;
			if(from=='G' && to=='R') return true;
		}
		return false;
	}
	
	//그룹을 찾아주는 BFS함수 
	static int go(String a[], boolean blind) {
		int n = a.length;
        boolean[][] c = new boolean[n][n];
        int ans = 0;							//그룹개수 
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (c[i][j] == false) {			//이전에 방문한적이 없다면 
                    ans += 1;					//그룹 개수 추가 
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i); q.add(j);
                    c[i][j] = true;				//방문처리 
                    
					while(!q.isEmpty()) {
						int x=q.remove();
						int y=q.remove();
						for(int k=0; k<4; k++) {
							int nx=x+dx[k];
							int ny=y+dy[k];
							if(0<=nx && nx<n &&ny>=0 && ny<n) {		//범위 설정 
								if(c[nx][ny]==false) {				//방문한적 없다면 
									if(can(blind,a[x].charAt(y), a[nx].charAt(ny))) { //그룹으로 묶는게 가능한지 확인후 
										q.add(nx); q.add(ny);
										c[nx][ny]=true;
									}
								}
							}
						}
						
					}
				}
			}
		}
		return ans;					//그룹개수 리턴 
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);	
		
		int n=sc.nextInt();
		String a[] = new String[n];
		
		for(int i=0; i<n; i++) {
			a[i]=sc.next();
		}
		
		System.out.println(go(a,false)+" "+go(a,true));	//적록색약 아닌경우, 적록색약인경우 출력 
	}
}
