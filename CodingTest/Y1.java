/**
 * y coding test #1
 * string 관련문제 :
 * 	내 솔루션 : test case(100%) / hidden case(60%) / time complexity (0%) 
 * @author Gunhoo
 *
 */
public class Y1 {

	 public static void main(String[] args) {
	    	String S = "BANANBA";
	    	StringBuilder newString = new StringBuilder("");
	    	int answer =0;
	    	while(true) {
	    		if(newString.length() != 0) {
	    			S = newString.toString();
	    		}
	    		if(S.length() < 6) break; // 만약 남은 string길이가 6 미만이면 성립할 수 없으므로 탈출
	    		if(S.equals("BANANA")) {
	    			answer++; break;
	    		}
	    		newString = new StringBuilder("");
//	         	Map<Character, Integer> fill = new HashMap<>();
//	        	fill.put('B', 0);fill.put('N', 0);fill.put('A', 0);
	    		int[] fill = new int[3]; // 0은 B 1은A 2는N
	        	for(int i =0 ; i < S.length(); i++) {
	        		if(S.charAt(i) == 'N') {
	        			int remain = fill[2];
	        			if(remain >= 2) {
	        				newString.append(S.charAt(i));
	        				continue;
	        			}
	        			fill[2]= remain+1;
	        		}else if(S.charAt(i) == 'B') {
	        			int remain = fill[0];
	        			if(remain >= 1) {
	        				newString.append(S.charAt(i));
	        				continue;
	        			}
	        			fill[0]= remain+1;
	        		}else if(S.charAt(i) == 'A') {
	        			int remain = fill[1];
	        			if(remain >= 3) {
	        				newString.append(S.charAt(i));
	        				continue;
	        			}
	        			fill[1]= remain+1;
	        		}else {
	        			newString.append(S.charAt(i));
	        		}
	        	}
	        	if(fill[0] < 1 || fill[2] < 2 || fill[1] < 3) break;
	        	if(fill[0] == 1 && fill[2] == 2 && fill[1] == 3 && S.length() == 6) {
	        		answer++; break;
	        	}
	        	answer++;
	    	}
	    	System.out.println(answer);
	    }

}
