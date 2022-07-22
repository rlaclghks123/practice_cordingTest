package bfsPractice;

public class targetNumber {

class Solution {
    int numbers[];			//재귀 함수일 경우 여러번 호출해야 하는데, 값이 변하지 않으며 매번 전달하는데 부담이 된다.  	
    int target;				// 따라서 멤버변수로 담아준다. 
    int answer;
    
    public void dfs(int index, int sum){
        if(index==numbers.length){			//numbers[] 의 크기만큼 다 돌았을 경우(마지막일경우) 
            if(sum==target){				//sum이 목표인 target과 같을경우 
                answer++;					//정답이므로 ++ 해준다. 
            }
            return ;						//void 이기 때문에, 종료시켜주고 
        }
        dfs(index+1, sum+numbers[index]);	//+ 인 경우 처리  
        dfs(index+1, sum-numbers[index]);	//- 인 경우 처리   
    }
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        
        dfs(0,0);
        return answer;
    }
}
}