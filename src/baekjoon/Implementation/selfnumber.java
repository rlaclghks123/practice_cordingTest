package Implementation;


public class selfnumber {
	
			
		static boolean c[];
				
		public static void main(String[] args) {
		
		//1. 1부터 10000까지 돌면서 셀프넘버가 아닌수를 방문처리하기 위해 boolean [] 생성
		c = new boolean[10001];
		
		//2. 1~10000까지 돌면서 셀프넘버가 아닌 수를 찾는다.
		for(int i=1; i<=10000; i++) {
			int n=d(i);
			
			//10001보다 작은 모든 셀프넘버가 아닌수를 방문처리
			if(n<10001) {
				c[n]=true;				
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(!c[i]) {
				System.out.println(i);
			}
		}

	}
		//ex) 1234 -> 1234+1+2+3+4
		public static int d(int number) { 
			int sum=number;				//현재수를 담는다.  ex)1234
			
			while(number!=0) {			//0이 되기 전까지 10으로 나누면서 1의자리 숫자를 더해준다. 
				sum=sum+(number%10);	 	//ex) 1 + 2 + 3 + 4 
				number/=10;
			}
			return sum;					//1234+1+2+3+4 = 1244
		}
}
