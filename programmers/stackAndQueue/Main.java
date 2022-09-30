package stackAndQueue;

import java.util.*;

public class Main {
	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        
	        int n=sizes.length;
	        int m=sizes[0].length;
	        
	        int lmax=sizes[0][0];
	        int rmax=sizes[0][1];
	        
	        for(int i=1; i<n; i++) {
	        	int left=sizes[i][0];
	        	int right=sizes[i][1];
	        	
	        	
	        	
	        	if(right>lmax && left<rmax) {
	        		lmax=right;
	        	}else if(left>rmax && right<lmax) {
	        		rmax=left;
	        	}
	        }
	        return answer = lmax*rmax;
	    }
	}
}

//2중 fo