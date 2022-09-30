package kakaoBlindRecruiment2022;

import java.util.*;

public class 양과늑대 {

	
	class Solution {
		
		int info[];
		ArrayList<Integer> arr[];
		int maxSheep = 0;
		
	    public int solution(int[] info, int[][] edges) {
	       this.info = info;
	       arr = new ArrayList[info.length];
	       
	       for(int edge[]:edges) {
	    	   int parent = edge[0];
	    	   int child = edge[1];
	    	   
	    	   if(arr[parent]==null) {
	    		   arr[parent] = new ArrayList<>();
	    	   }
	    	   
	    	   arr[parent].add(child);
	       }
	       
	       ArrayList<Integer> list = new ArrayList<>();
	       list.add(0);
	       dfs(0,0,0,list);
	       
	        return maxSheep;
	    }
	    
	    public void dfs(int index, int sheep, int wolf, ArrayList<Integer> nextList) {
	    	if(info[index]==0) sheep++;
	    	else wolf++;
	    	
	    	if(wolf>=sheep) return;
	    	
	    	maxSheep = Math.max(sheep, maxSheep);
	    	
	    	ArrayList<Integer> list = new ArrayList<>();
	    	list.addAll(nextList);
	    	list.remove(Integer.valueOf(index));
	    	
	    	if(arr[index]!=null) {
	    		for(int child:arr[index]) {
	    			list.add(child);
	    		}
	    	}
	    	
	    	for(int next:list) {
	    		dfs(next,sheep,wolf,list);
	    	}
	    }
	}
}
