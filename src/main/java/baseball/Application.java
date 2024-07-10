package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    	

    }
    
    // 정답 number를 생성하는 메소드 입니다.
    private static int number() {
    	//int num = RandomNum9to1();
    	int[] num = {1,2,3,4,5,6,7,8,9};
    	int check = 0;
    	StringBuilder sb = new StringBuilder();
    	while(check < 3) {
    		int i = RandomNum9to1();
    		if(num[i] != 0) {
    			check++;
    			sb.append(num[i]);
    			num[i] = 0;
    		}
    	}
    	
    	int baseball = Integer.parseInt(sb.toString());
    	
    	return baseball;
    	
    }
    
    // 9에서 1까지의 랜덤한 숫자를 반환하는 메소드입니다.
    private static int RandomNum9to1() {
    	return (int)(Math.random()*9);
    }
    
    
}
