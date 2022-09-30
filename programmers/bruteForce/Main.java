package bruteForce;

import java.util.*;

public class Main {

	class Solution {
		
	ArrayList<String> list;	
	boolean c[];
	
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        c= new boolean[tickets.length];
        
        //시작점, 경로, 티켓, 횟수로 dfs를 통해 횟수를 찾아 ArrayList에 담아준다.
        list = new ArrayList<>();
        
        dfs("ICN","ICN",tickets,0);
        
        // 알파벳 순으로 나타내도록 정렬해준다. list이므로 Collections 사용 
        Collections.sort(list);
        
        //정답을 answer에 담은뒤 출력해준다.
        answer = list.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String start, String route, String tickets[][], int cnt) {
    	if(tickets.length == cnt) {
    		list.add(route);
    	}
    	
    	for(int i=0; i<tickets.length; i++) {
    		
    		if(start.equals(tickets[i][0]) && c[i]==false) {
    			c[i]=true;
    			dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
    			c[i]=false;
    		}
    	}
    }
}
	}
