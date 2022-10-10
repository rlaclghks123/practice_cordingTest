package 문자열;
import java.io.*;
import java.util.*;

public class 하얀칸1100 {
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);

		int n=8; 			//8 x 8 체스판이기 때문에 
		int cnt=0;			//하얀판에 말의 개수를 측정하기 위함 
		
		char map[][] = new char[n][n];		//map을 만들어준다.
		
		for(int i=0; i<n; i++) {
			map[i] = sc.next().toCharArray();	
		}
		
		for(int i=0; i<n; i++) {
			if(i%2==0) {					//짝수행일 경우 흰 검 흰 검 으로 가기 때문에 
				for(int j=0; j<n; j++) {
					if(j%2==0) {			//짝수 열을 찾아준다.
						if(map[i][j]=='F') {	//짝수행 짝수열에 말이 있다면 
							cnt++;			//개수를 추가해준다.
						}
					}
				}
			}else {							//홀수 행 일 경우 검 흰 검 흰 으로 가기때문에 
				for(int j=0; j<n; j++) {
					if(j%2==1) {			//홀수 열을 찾아준다.
						if(map[i][j]=='F') {	//홀수행,홀수열에 말이 있다면 
							cnt++;			//개수를 추가해준다.
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}