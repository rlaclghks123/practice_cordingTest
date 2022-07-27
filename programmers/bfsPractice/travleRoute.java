package bfsPractice;

import java.util.*;

public class travleRoute {

	class Solution {
	    
	    boolean c[];		//방문 처리를 위한 배열 
	    ArrayList<String> allRoutes;	//값을 저장할 배열.
	    
	    public String[] solution(String[][] tickets) {
	        String[] answer = {};
	        c= new boolean[tickets.length];
	        allRoutes = new ArrayList<>();
	        int cnt=0;
	            
	        bfs("ICN","ICN",tickets,cnt);		//시작을 ICN, 현재 경로가 ICN 이므로 
	        Collections.sort(allRoutes);		//알파벳순으로 정렬 해야되기 때문에 정렬한다.
	        answer=allRoutes.get(0).split(" ");	//" "를 기준으로 모든 경로를 answer에 넣어준다. 
	        return answer;
	    }
	    
	    public void bfs(String start, String route, String[][]tickets, int cnt){
	        if(cnt==tickets.length){
	            allRoutes.add(route);
	            return;
	        }
	        
	        for(int i=0; i<tickets.length; i++){
	            if(start.equals(tickets[i][0]) && c[i]==false){		//시작부분과 입력배열부분이 같을경우 && 방문한적 없다면 
	                c[i]=true;										//방문처리 
	                bfs(tickets[i][1],route+" "+tickets[i][1],tickets,cnt+1);	//시작부분을 바꿔주고, 경로도 추가 
	                c[i]=false;										//되돌려주기 
	            }
	        }
	    }
	}
}
