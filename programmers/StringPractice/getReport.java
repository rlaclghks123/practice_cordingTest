package StringPractice;

import java.util.*;
public class getReport {

class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        
	    	//answer의 크기를  id_list의 크기만큼 설정 해준다. 
	        int [] answer = new int[id_list.length];
	        
	        
	        // 1 Hashset을 통해 중복제거 
	        HashSet<String> reportSet = new HashSet<>();
	        
	        for(String rep : report)  reportSet.add(rep); //기존의 report값을 hashSet을 통해 중복을 제거해준다. 
	        	
	        // 2 HashMap을 통해 key값, value값으로 저장한다.  
	        // 이때 key값은 신고 받은사람, value값은 arrayList로 신고한 사람들을 나타낸다.
	        
	        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();  //HashMap 생성 
	        for(String rep : reportSet) {				//중복제거한 reportSet에서 하나씩 가져온다 
	        	int blank = rep.indexOf(" ");			//" "을 기준으로 index값을 가져온다. 
	        	String reporter = rep.substring(0, blank);	//신고자를 찾아준다. 
	        	String reportee = rep.substring(blank+1);	//신고받은 사람을 찾아준다. 
	        	
	        	ArrayList<String> reportList = notifyListHash.getOrDefault(reportee, null);	//신고한 사람들을 담은 배열 없다면 Null 
	        	if(reportList == null) reportList= new ArrayList<String>(); 		// Null일 경우 빈배열로 생성 
	        	
	        	reportList.add(reporter);						//신고자를 배열에 담아준다. 
	        	notifyListHash.put(reportee, reportList);		//신고자를 수정한 배열을 기존의 Map에 수정해준다.
	        }
	        
	        //3 notifyListHash를 기반으로 reporterHash를 만들어준다. 
	        // key값은 신고받은사람  value값은 신고받은 횟수  
	        HashMap<String,Integer> reporterHash = new HashMap<>(); //HashMap 생성 		
	        for(ArrayList<String> notifyList : notifyListHash.values()) {	//신고한 사람들을 담은 배열을 가져온다.  
	        	if(notifyList.size()>=k) {					//만약 k번 이상이라면   이때 k는 게시판 이용 정지 횟수  
	        		for(String reporter : notifyList) {		//신고한 사람들을 담은 배열에서 한명씩 꺼내서 
	        			reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0)+1); 
	        			//key값은 신고한 사람, value값은 횟수를 담아준다.    
	        			
	        		}
	        	}
	        }
	        
	        for(int i=0; i<id_list.length; i++) {
	        	answer[i]=reporterHash.getOrDefault(id_list[i], 0); //answer에 id_list의 이름을통해 값을 담아준다. 
	        }
	        return answer;
	    }
    }	
}
