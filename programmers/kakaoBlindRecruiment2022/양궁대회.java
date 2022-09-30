package kakaoBlindRecruiment2022;

import java.util.Arrays;

public class 양궁대회 {

	class Solution {
	    public int[] solution(int n, int[] info) {
	        int[] answer = new int[11];
	        int temp[] = new int[11];
	        int maxDiff = 0;
	        
	        //비트마스크를 이용해 10개를 왼쪽으로 움직여 비교해준다.
	        for(int i=1; i<(1<<10); i++) {
	        	int lion =0;		//lion의 총점 
	        	int apeach=0;		//apeach의 총점 
	        	int cnt=0;			//lion이 이길경우 총 count 한 개수 
	        	
	        	for(int j=0; j<10; j++) {		//0번째 index부터 비교해준다.
	        		if((i&(1<<j))!=0) {			//i번째 수를 j번째 값을 비교해 0이 아닐경우 lion을 이기도록 해준다.
	        			lion+=10-j;				//0번부터 i번까지중 0번째가 10점이므로 10-i값을 lion에 추가해준다. 
	        			temp[j]=info[j]+1;		//이기도록 apeach보다 한발 더 쏴준다. .
	        			cnt+=temp[j];			//총 던진 화살수를 count 해준다.	
	        		}
	        		
	        		else { 						//apeach가 이기는경우 
	        			temp[j]=0;				// 0일경우 		
	        			if(info[j]>0) {			//apeach의 값이 0이 아닐경우  
	        				apeach+=10-j;		//apeach에 값을 추가해준다.
	        			}
	        		}
	        	}
	        	if(cnt>n) continue;			
	        	
	        	temp[10] = n-cnt;				// 카운트하고 남은값은 마지막 0점에 넣어준다.
	        	
	        	//lion과 apeach를 비교해 가장 큰 차이가 나는 값을 찾아준다.
	        	if(lion-apeach==maxDiff) {		//만약 최대값이 여러개일경우 
	        		for(int j=10; j>=0; j--) {	//뒤에서부터 비교해서 더 많은 값을 가질경우를 찾아준다.
	        			if(temp[j]>answer[j]) {
	        				maxDiff = lion-apeach;
	        				answer = Arrays.copyOf(temp, temp.length);
	        				break;
	        			}else if(temp[j]<answer[j]) {
	        				break;
	        			}
	        		}
	        	}
	        	else if(lion-apeach > maxDiff) {
	        		maxDiff = lion-apeach;
    				answer = Arrays.copyOf(temp, temp.length);	
	        	}
	        }
	        if(maxDiff==0) return new int[] {-1};			//만약 lion이 apeach를 못이길경우 -1 리턴 
	        //lion이 apeach를 못이기는경우 
	        return answer;
	    }
	}
}
