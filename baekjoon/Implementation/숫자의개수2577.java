package Implementation;



import java.io.*;
import java.util.*;
		
public class 숫자의개수2577 {
	
	public static void main(String args[])throws IOException {
      Scanner sc = new Scanner(System.in);
      
      int first=sc.nextInt();			//첫번째 숫자
      int second=sc.nextInt();			//두번째 숫자
      int third=sc.nextInt();			//세번째 숫자
      
      int box[] = new int[10];			//0~9까지의 숫자의 개수를 측정할 배열
      
      String ans= Integer.toString(first*second*third);		//값이 너무 크므로 String으로 바꿔준다.
      
      for(int i=0; i<ans.length(); i++) {
    	  int result= ans.charAt(i)-'0';					// 총 곱한값의 한자리를 가져와  
    	  for(int j=0; j<=9; j++) {							// 0~9까지 찾아서 
    		  if(result==j) {								// 같은경우 
    			  box[j]++;									// 개수를 찾아준다
    		  }
    	  }
      }
      for(int i=0; i<=9; i++) {
    	  System.out.println(box[i]);						//총 개수 출력 
      }
}
}


