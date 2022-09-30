package stackAndQueue;

import java.util.*;

public class crossingBridgeWithTruck {

	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	     
	    	//큐를 만들어준다.(다리)
	    	Queue<Integer> q = new LinkedList<>();
	    	
	    	int time=0;		//총 걸린시간 
	    	int sum=0;		//트럭의 무게 합
	    	
	    	for(int truck:truck_weights) {
	    		while(true) {
	    			
	    			//다리에 트럭이 없는경우
	    			if(q.isEmpty()) {
	    				q.add(truck);
	    				sum+=truck;
	    				time++;
	    				break;
	    			}
	    			
	    			//다리에 트럭이 꽉찬경우
	    			else if(q.size()==bridge_length) {
	    				sum-=q.poll();
	    			}
	    			
	    			//다리에 트럭이 있는경우 
	    			else {
	    				//트럭의 무게가 한계를 초과할경우 
	    				if(sum+truck>weight) {
	    					q.add(0);	//0을 넣어줌으로서 기존의 트럭을 보낸다.
	    					time++; 
	    				}
	    				//트럭의 무게가 한계를 넘지않는경우
	    				else {
	    					q.add(truck);
	    					sum+=truck;
	    					time++;
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	return time+bridge_length;   // 마지막 트럭이 다리에 있기때문에 다리길이만큼 추가해준다.
	    }
	}
	
}
