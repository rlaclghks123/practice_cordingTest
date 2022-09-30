package StringPractice;

import java.util.*;

public class Main {
	
	class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //신고자의 중복을 방지하기 위해 set을 사용한다.
        HashSet<String> set = new HashSet<>();
        
        //report의 값을 set에 넣어준다,
        for(String rep:report) set.add(rep);
        
        // <신고당한자, <신고한자들list> > 로 map을 만들어준다.
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        //중복을 제거한 set의 값으로부터 신고한자, 신고당한자를 찾아준다.
        for(String rep:set) {
        	int index = rep.indexOf(" ");
        	
        	//신고한자를 찾아준다.
        	String reporter = rep.substring(0,index);
        	//신고당한자를 찾아준다.
        	String reportee = rep.substring(index+1);
        	
        	//신고당한자들을 넣을 list를 만들어준다.
        	ArrayList<String> list = map.getOrDefault(reportee, null);
        	
        	//list에 값이 없을 경우 빈 list를 채워준다.
        	if(list==null) list = new ArrayList<>();
        	
        	list.add(reporter);
        	map.put(reportee, list);
        }
        
        //list를 토대로 <reporter,신고당한횟수> map을 만들어준다.
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for(ArrayList<String> countList : map.values()) {
        	if(countList.size()>=k) {
        		for(String list:countList) {
        			countMap.put(list, countMap.getOrDefault(list, 0)+1);
        		}
        	}
        }
        
        //값을 answer에 담아준다.
        for(int i=0; i<id_list.length; i++) {
        	answer[i]=countMap.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}
}
