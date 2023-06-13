package lv2;

import java.util.*;

class Discount {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        init: for(int i=0; i<= discount.length-10; i++){  // 할인 배열 가능 길이만큼 체크
            int[] tmpNumber = Arrays.copyOf(number, number.length);
            next: for(int j=i; j < i+10 ; j++){ // 10개 연속인지 체크
                for(int k=0; k<want.length; k++){ // 원하는 목록에 있는지 체크
                    if(want[k].equals(discount[j]) && tmpNumber[k] > 0){ // 만약 존재하고, 남은 수량 존재하면,
                        tmpNumber[k]--; // 수량 감소시키고
                        continue next;
                    }else if(want[k].equals(discount[j])){ // 일치하는데 남은 수량 없으면 더이상 살게 없다는 뜻이므로
                        continue init; // 탈출
                    }
                }
                // 정현이가 살 목록이 없다면 더이상 볼 필요가 없다
                continue init;
            }
            answer++; // 전부 담긴 상황이므로 정답 추가
        }
        return answer;
    }
}