package 문자열;


import java.io.*;
import java.util.*;


public class 듣보잡1764 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		ArrayList<String> arr = new ArrayList<>();				//입력문자열을 담을 ArrayList생성 
		HashSet<String> h = new HashSet<>();					//중복체크를 할 HashSet 생성 
		
		for(int i=0; i<n+m; i++) {
			String s = sc.next();								//입력값 추가 
			arr.add(s);
			h.add(s);
		}
		
		ArrayList<String> ans = new ArrayList<>();				//중복되는 정답을 담을 ArrayList 
		for(String a:arr) {
			if(h.contains(a)) {									//만약 방문했다면  
				h.remove(a);									//제거해준다.
			}else {
				ans.add(a);										//중복인 경우 정답을 담아준다.
			}
		}
		Collections.sort(ans);									//사전순으로 출력하기 위해 정렬 
		System.out.println(ans.size());							//총 개수 출력 
		for(String s:ans) {
			System.out.println(s);								//중복된 문자열 출력 
		}
	}
}

