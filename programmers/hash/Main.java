package hash;
import java.util.*;

public class Main {
	
	class Printer{
		int priority;
		int location;
		public Printer(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}
	}
	
	class Solution {
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        ArrayList<Printer> list = new ArrayList<>();
	        
	        int turn =0;
	        for(int i=0; i<priorities.length; i++) {
	        	Printer now = list.remove(0);
	        	if(list.stream().anyMatch(other->now.priority<other.priority)){
	        		list.add(now);
	        	}else {
	        		turn++;
	        		if(now.location==location) {
	        			break;
	        		}
	        	}
	        }
	        return turn;
	    }
}
	
}
