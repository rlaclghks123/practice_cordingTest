package 문자열;
import java.io.*;
import java.util.*;

public class AC5430 {

	 
	public static StringBuilder sb = new StringBuilder();		
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		ArrayDeque<Integer> deque;					//순서바꾸기와, 삭제를 하기에 덱이 적합하기에 덱 사용 
		StringTokenizer st;							//문자열을 분리하기 위해 사용 

		int t=sc.nextInt();
		
		while(t --> 0) {
			
			String ctrl = sc.next();				//어떻게 할것인지
			int n=sc.nextInt();
			
			st = new StringTokenizer(sc.next(), "[],");		//[], ,를 제거해준다. 
			deque = new ArrayDeque<>();
			
			for(int i=0; i<n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));		//덱에 int형으로 넣어준다.
			}
			
			AC(deque,ctrl);									
			}
			System.out.println(sb);
	}
	
	public static void AC(ArrayDeque<Integer> d , String ctrl) {
		
		boolean isRight = true;					//정방향이냐, 역방향이냐를 결정하기 위함 
		
		for(char c:ctrl.toCharArray()) {		//문자를 뽑아준다.
			if(c=='R') {						//R(역방향)이라면 isRight의 값을 바꿔준다. 
				isRight=!isRight;
				continue;
			}
			
			if(isRight) {						//정방향일 경우 
				if(d.pollFirst()==null) {		//덱의 첫번째 값이 비어있다면 
					sb.append("error\n");		//에러출력 
					return ;
				}
			}else {								//역방향 일 경우 
				if(d.pollLast()==null) {		//덱의 마지막값이 비어있다면 
					sb.append("error\n");		//에러출력 
					return ;
				}
			}
		}
		makePrint(d,isRight);					//int형을 다시 [, , ,] 안에 넣어준다. 
	}
	
	public static void makePrint(ArrayDeque<Integer> d, boolean isRight) {
		sb.append('[');							//처음에 [ 를 추가해준다.
		
		if(d.size()>0) {						//비어있지 않다면
			if(isRight) {						//정방향인가?
				sb.append(d.pollFirst());		//첫번째 값을 넣어준뒤 
				
				while(!d.isEmpty()) {			//덱에있는 모든값을 출력해준다. 
					sb.append(',').append(d.pollFirst());
				}
			}
			else {								//역방향일경우 
				sb.append(d.pollLast());		//마지막값을 출력해주고 
				while(!d.isEmpty()) {			//덱에 있는 모든값을 뒤에서부터 출력 
					sb.append(',').append(d.pollLast());
				}

			}
		}
		sb.append(']').append('\n');			//마지막에 ]를 추가해주고 한줄 띄어준다. 
	}
}
