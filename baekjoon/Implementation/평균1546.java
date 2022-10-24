package Implementation;


import java.io.*;
import java.util.*;
		
public class 평균1546 {
				
		
		public static void main(String args[])throws IOException {
	      Scanner sc = new Scanner(System.in);
	      int n=sc.nextInt();
	      int box[] = new int[n];
	      double ans=0;
	      
	      for(int i=0; i<n; i++) {
	    	  box[i]=sc.nextInt();			//입력값을 배열에 넣어준다.
	      }
	      Arrays.sort(box);					//최대값을 찾기위해 정렬한다.
	      
	      double max=box[n-1];				//최대값을 찾아준다. 
	  
	      
	      for(int i=0; i<n; i++) {

	    	  ans+=box[i]/max*100;			//세준이 방식으로 총합을 구한다.
	      }
	      System.out.println(ans/n);		//세준이 방식으로 평균을 구한다.
	      
		}
	}