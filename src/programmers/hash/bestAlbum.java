package hash;
import java.util.*;

public class bestAlbum {
	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	    	
	    	// 1. map을 만든다.
	    	HashMap <String, Integer> map = new HashMap<>();
	    	
	    	// 2. map을 key:genres, value:plays 로 채워준다.
	    	for(int i=0; i<genres.length; i++) {
	    		map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
	    	}
	    	
	    	// 3. genres를 담아둘 arrayList를 만들어준다. map은 순서가 없는데 정렬이 필요하기 때문에 key값을 ArrayList로 빼준다. 
	    	ArrayList<String> genre = new ArrayList<>();
	    	
	    	// 4. genre에 key값을 넣어준다. 
	    	for(String key:map.keySet()) {
	    		genre.add(key);
	    	}
	    	
	    	// 5. genre를 map의 value값을 통해 내림차순으로 정렬해준다.
	    	Collections.sort(genre ,(o1,o2) -> map.get(o2) - map.get(o1));
	    	
	    	// 6. 정답을 담을 ArrayList를 만들어준다. 
	    	ArrayList<Integer> list = new ArrayList<>();
	    	
	    	// 7. genre중 최대값과, 두번째값을 찾아준다.  
	    	for(int i=0; i<genre.size(); i++) { 		
	    		String g = genre.get(i);			
	    		int max=0;						//최대값을 담은 변수 
	    		int firstIndex = -1;			//최대값의 index값을 담은 변수  0번째 부터 시작하므로 -1로 초기화 
	    		for(int j=0; j<genres.length; j++) {	
	    			if(g.equals(genres[j]) && max<plays[j]) {		//genres의 값과 genre의 값이 같으면서, 현재값이 최대값보다 클경우  
	    				max=plays[j];								//최대값을 바꿔준뒤 
	    				firstIndex=j;								//최대값 index를 구해준다.
	    			}
	    		}
	    		
	    		max=0;												//최대값 초기화 
	    		int secondIndex=-1;									//두번째 큰값의 index값을 담을 변수 
	    		for(int j=0; j<genres.length; j++) {
	    			if(g.equals(genres[j]) && max<plays[j] && j!=firstIndex){		//최대값을 구하지만 첫번째 최대값 다음값 구하기 위해 
	    				max=plays[j];
	    				secondIndex=j;
	    			}
	    		}
	    		list.add(firstIndex);								//최대값을 담아준다. 
	    		if(secondIndex>=0) list.add(secondIndex);			//두번째값은 존재안할수도 있기때문에 존재할 경우만 추가(index값이 0부터 시작하므로 0 이상) 
	    	}
	    	int result [] = new int [list.size()];
	    	for(int i=0; i<list.size(); i++) {
	    		result[i]=list.get(i);
	    	}
	    	return result;
	    }  
	}
}
