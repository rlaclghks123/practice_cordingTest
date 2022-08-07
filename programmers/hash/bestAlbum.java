package hash;
import java.util.*;

public class bestAlbum {
	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	    	// 1. map을 만든다.
	    	HashMap <String, Integer> map = new HashMap<>();
	    	
	    	for(int i=0; i<genres.length; i++) {
	    		map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
	    	}
	    	
	    	// 2. genre를 담아둘 arrayList를 만들어준다.
	    	ArrayList<String> genre = new ArrayList<>();
	    	for(String key:map.keySet()) {
	    		genre.add(key);
	    	}
	    	
	    	// 3. genre를 value값을 내림차순으로 정렬해준다.
	    	Collections.sort(genre ,(o1,o2) -> map.get(o2) - map.get(o1));
	    	
	    	// 4. int를 담을 ArrayList를 만들어준다. 
	    	ArrayList<Integer> list = new ArrayList<>();
	    	
	    	// 5. genre중 최대값을 찾아준다. 
	    	for(int i=0; i<genre.size(); i++) {
	    		String g = genre.get(i);
	    		int max=0;
	    		int firstIndex = -1;
	    		for(int j=0; j<genres.length; j++) {
	    			if(g.equals(genres[j]) && max<plays[j]) {
	    				max=plays[j];
	    				firstIndex=j;
	    			}
	    		}
	    		
	    		max=0;
	    		int secondIndex=-1;
	    		for(int j=0; j<genres.length; j++) {
	    			if(g.equals(genres[j]) && max<plays[j] && j!=firstIndex){
	    				max=plays[j];
	    				secondIndex=j;
	    			}
	    		}
	    		list.add(firstIndex);
	    		if(secondIndex>=0) list.add(secondIndex);
	    	}
	    	int result [] = new int [list.size()];
	    	for(int i=0; i<list.size(); i++) {
	    		result[i]=list.get(i);
	    	}
	    	return result;
	    }  
	}
}
