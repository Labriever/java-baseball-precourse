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
    			
    			// 예외처리 완
    			
    			// 메인 기능 구현
    			//정답 데이터
    			int A1, A2, A3;
    			
    			A3 = answer % 10; // 1의 자리
    			A2 = ((answer % 100) - A3)/10; // 10의 자리
    			A1 = (answer - (answer % 100))/100; // 100의 자리
    			
    			int[] answerArr = {A1, A2, A3};
    			
    			// 입력 데이터
    			int B1, B2, B3;
    			B3 = baseball % 10; // 1의 자리
    			B2 = ((baseball % 100) - B3)/10; // 10의 자리
    			B1 = (baseball - (baseball % 100))/100; // 100의 자리
    			
    			int[] baseballArr = {B1, B2, B3};
    			int ball = 0, strike = 0;
    			
    			for(int i=0; i<3;i++) {
    				for(int j=0; j<3;j++) {
        				if(answerArr[i] == baseballArr[j]) {
        					if(i == j) {
        						strike++;
        					}else {
        						ball++;
        					}
        					break;
        				}
        			}	
    			}
    			
    			if(ball > 0) {
    				System.out.print(ball+"볼");
    			}
    			if(strike > 0) {
    				System.out.print(strike+"스트라이크");
    			}
    			System.out.println();
    			if(strike==3) {
    				isCollect = true;
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
