package bfsPractice;

import java.util.*;

public class Four_calculation14395 {

	// 최소 연산을 구하는 문제 -> 숫자 - 숫자의 최단거리 BFS
	// 범위가 큰데 어떻게 BFS? => 실제 -,/는 거의 안쓰고, +,*만 쓰는데 제곱수 이므로 숫자자체는 얼마 안큼 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		long s=sc.nextLong();		//범위가 크기때문에 long으로받는다.
		long t=sc.nextLong();
		
		Queue<Long> q = new LinkedList<>();		//q 또한 long 
		Queue<String> qs = new LinkedList<>();
		HashSet<Long> check = new HashSet<>();	// 배열로 체크하기엔 너무 커서 HashSet사용(중복방지,크기변형)
		Long limit = 1000000000L;				//범위 최대값 
		
		q.add(s);					// s부터 탐색 
		qs.add("");					// 처음엔 "" 빈 문자열 
		check.add(s);				//방문처리 
		
		while(!q.isEmpty()) {
			long x=q.remove();	
			String str = qs.remove();
			
			if(x==t) {					// 목표인 t값과 같다면 
				if(str.length()==0) {	//str이 0일 경우 
					str="0";			//"0"으로 표시 
				}
				System.out.println(str);	//str 출력 
				System.exit(0);				//출력후 즉시 종료 
			}
			
			if(0<=x*x && x*x<=limit && check.contains(x*x)==false) {
				q.add(x*x);
				qs.add(str+"*");
				check.add(x*x);
			}
			
			if(0<=x+x && x+x<=limit && check.contains(x+x)==false) {
				q.add(x+x);
				qs.add(str+"+");
				check.add(x+x);
			}
			
			if(0<=x-x && x-x<=limit && check.contains(x-x)==false) {
				q.add(x-x);
				qs.add(str+"-");
				check.add(x-x);
			}
			
			if(x!=0 && 0<=x/x && x/x<=limit && check.contains(x/x)==false) {	//문제에서 0이 아닐경우에만 / 가능 
				q.add(x/x);
				qs.add(str+"/");
				check.add(x/x);
			}
		}
		System.out.println(-1); 		//바꿀수 없는경우 -1출력 
	}

}
