package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    	Scanner sc = new Scanner(System.in);
    	
    	int continueGame = 1;
    	while(continueGame == 1) {
    		int answer = number();
    		boolean isCollect = false;
    		while(! isCollect) {
    			System.out.print("숫자를 입력해주세요 : ");
    			int baseball = 0;
    			try {
    				baseball = sc.nextInt();
    			}catch(InputMismatchException e) {
    				System.out.println("숫자를 입력해주세요.");
    				sc.next(); // 잘못된 값 입력 버퍼에서 제거.
    				continue;
    			}
    			
    			// 3자리 수가 아니면 
    			int checkNum = (baseball/100);
    			if(checkNum >= 10 || checkNum <= 0) {
    				System.out.println("3자리의 숫자를 입력하세요");
    				continue;
    			}
    			
    			
    			
    		}
    		
    		System.out.println("3개의 숫자를 모두 맞췄습니다.");
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    		continueGame = sc.nextInt();
    	}
    	
    	sc.close();
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
