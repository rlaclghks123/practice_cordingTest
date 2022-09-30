package stackAndQueue;
import java.util.*;

public class developingFunction {

	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        // 정답을 담을 arrayList를 만들어준다.
	    	ArrayList<Integer> ans = new ArrayList<>();
	    	
	    	// 배포하는데 얼마나 걸리는지 구해준다.
	    	for(int i=0; i<progresses.length; i++) {
	    		double days = (100-progresses[i]) / (double) speeds[i];
	    		int daysUp = (int) Math.ceil(days);
	    		
	    		//함께 배포 가능한 기능의 index 찾기.
	    		int j=i+1;
	    		for(; j<progresses.length; j++) {
	    			if(progresses[j]+daysUp*speeds[j] <100) {
	    				break;
	    			}
	    		}
	    		
	    		// 총 배포 가능한 기능 개수를 ArrayList에 담고, 배포 index를 초기화해준다.
	    		ans.add(j-i);
	    		i=j-1;
	    	}
	        
	    	

	    	//arrayList를  배열로 옮긴뒤, 출력해준다.  stream, mapToInt,toArray 사용 
	    	return ans.stream().mapToInt(i->i.intValue()).toArray();
	    	
	    	//stream 사용하지 않고 반복문을 통해 ArrayList = > int [] 로
//	    	int answer[] = new int[ans.size()];
//	    	
//	    	for(int k=0; k<ans.size(); k++) {
//	    	answer[k]=ans.get(k);	
//	    	}
	    	
	    }
	}

}

//     progress         		speed					return
// [93, 30, 55]					[1, 30, 5]				[2, 1]
// [95, 90, 99, 99, 80, 99]		[1, 1, 1, 1, 1, 1]		[1, 3, 2]