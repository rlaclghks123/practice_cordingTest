package gridPractice;

import java.util.*;

public class Matrix1080 {

	//3x3 행렬의 값을 1->0 , 0->1로 바꿔주기 위한 함수 
	static void flip(int a[][], int x, int y) {
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				a[i][j]=1-a[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int a[][] = new int[n][m];			 
		int b[][] = new int[n][m];			
		
		for(int i=0; i<n; i++) {				//행렬 A 입력 
			String str = sc.next();
			for(int j=0; j<m; j++) {
				a[i][j]=str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<n; i++) {				//행렬 B입력 
			String str = sc.next();
			for(int j=0; j<m; j++) {
				b[i][j]=str.charAt(j)-'0';
			}
		}
		
		int ans=0;
		for(int i=0; i<n-2; i++) {				//3x3 행렬의 왼쪽 맨위 부분을 통해 체크 
			for(int j=0; j<m-2; j++) {
				if(a[i][j]!=b[i][j]) {			//다르다면 
					ans++;						//개수 추가 
					flip(a,i+1,j+1);			//flip 해준다. 
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]!=b[i][j]) {			//변경했음에도 다르다면 
					System.out.println(-1);		//-1 출력 
					System.exit(0);
				}
			}
		}
		
		System.out.println(ans);				//개수 출력 

	}

}
