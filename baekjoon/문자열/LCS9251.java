package 문자열;

	import java.io.*;
	import java.util.*;


public class LCS9251 {

		static char s1[];				//첫번째 문자열의 부분집합을 나타냄 
		static char s2[];				//두번째 문자열의 부분집합을 나타냄
		static int d[][];				//LCS 총 개수를 나타냄 
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
				
			s1 = sc.next().toCharArray();			//첫번째 문자열을 부분집합으로 나타내준다.
			s2 = sc.next().toCharArray();			//두번째 문자열을 부분집합으로 나타내준다.
			
			d = new int[s1.length][s2.length];		//초기값 할당 
			
			for(int i=0; i<s1.length; i++) {
				for(int j=0; j<s2.length; j++) {
					d[i][j]=-1;						//방문 처리를 위해 -1로 초기값 설정
				}
			}
			System.out.println(LCS(s1.length-1, s2.length-1));		//LCS를 끝지점~처음까지 돌면서 최대값 출력
		}
		
		public static int LCS(int x, int y) {
			if(x==-1 || y==-1) {					//공집합일경우  0출력 
				return 0;
			}
			
			if(d[x][y]==-1) {						//방문한적 없다면 
				d[x][y]=0;							//방문처리 
				
				if(s1[x]==s2[y]) {					//s1의 x값과 s2의 y값이 같을경우 					
					d[x][y]=LCS(x-1,y-1)+1;			//D배열에 길이를 +1을 해준다. 
				}else {
					d[x][y]=Math.max(LCS(x-1,y), LCS(x,y-1));	//같지 않을경우 왼쪽과 위에값중 큰값을 담아준다. 
				}
			}
			return d[x][y];							//현재값의 길이를 return 한다.	
		}
	}


