package lv2;

public class MaxAndMin {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        String[] arr = s.split(" ");
	        
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        for(int i = 0; i < arr.length; i++){
	            int tmp = Integer.parseInt(arr[i]);
	            if(tmp < min) min = tmp;
	            if(tmp > max) max = tmp;
	        }
	        answer = "" + min + " " + max;
	        return answer;
	    }
	}
}
