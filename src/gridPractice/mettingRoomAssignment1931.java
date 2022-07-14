package gridPractice;

import java.lang.reflect.Array;
import java.util.*;

//기준 : 일찍 끝나는 회의를 기준으로 한다.

//자기자신과 새로운 객체를 비교 할 필요가 있기때문에 Comparable 사용해서 정렬 
class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	Meeting(int start, int end) {
		this.start=start;
		this.end=end;
	}
		
	public int compareTo(Meeting That) {
		if(this.end<That.end) {			//새로운 객체의 끝이 기존보다 크면 X 
			return -1;
		}else if(this.end==That.end) {  //끝이 같으면 시작을 기준으로 정렬 
			if(this.start<That.start) {	//새로운 객체의 시작이 기존객체의 시작보다 크면X 
				return -1;
			}else if(this.start==That.start) {	//같으면 0
				return 0;
			}else {						//반대면 true 
				return 1;
			}
		}else {							//반대면 true 
			return 1;
		}
	}
}
public class mettingRoomAssignment1931 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		Meeting[] a = new Meeting[n];
		
		for(int i=0; i<n; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			a[i]=new Meeting(start,end);
		}
		
		Arrays.sort(a);
		
		int last=-1;				//끝지점을 처음엔 -1로 지정 
		int ans=0;					//회의 개수 
		
		for(int i=0; i<n; i++) {
			if(last<=a[i].start) {		//만약 끝지점이 새로운회의 시작점과 크거나 같을경우 
				last=a[i].end;			//끝지점을 새로운회의의 끝점으로 변경 
				ans++;					//회의추가 
			}
		}
		System.out.println(ans);		//회의 개수 출력.
	}
}	