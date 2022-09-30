package stackAndQueue;

import java.util.*;

public class printer {

	 class PrintJob{
			int priority;
			int location;
			public PrintJob(int priority, int location) {
				this.priority=priority;
				this.location=location;
			}
		}
	  class Solution {

	  public int solution(int[] priorities, int location) {
		  
		  // class 생성 (priority, location 두 변수를 처리 하기위해)
		  
		  //class type의 List 생성
		  List<PrintJob> printer = new ArrayList<>();
		  
		  for(int i=0; i<priorities.length; i++) {
			  printer.add(new PrintJob(priorities[i],i));
		  }
		  
		  int turn=0;
		  while(!printer.isEmpty()) {
			  //0번째 값을 꺼내서 최고 우선 순위인지 확인한다.  
			  PrintJob job = printer.remove(0);
			 
			  //최고 우선순위가 아닐경우 list에 다시 추가해준다.
			  if(printer.stream().anyMatch(other->job.priority<other.priority)) {
				  printer.add(job);
			  }
			  //최고 우선순위일 경우 
			  else {
				  turn++;   //turn+1을 해준다.
				  if(location==job.location) {
					  break;					//찾는 index값일경우 break;
				  }
			  }
		  }
		  return turn;
	  }   
}	  	  

}
