package step02;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        Calculator calculator = new Calculator();

        System.out.println("양의 정수 계산기");
        System.out.println("두 개의 양의 정수 및 사칙연산기호 (+, -, *, /)를 입력하면 계산합니다.");

        while(true) {
            for(int i = 0; i < nums.length; i++) {
                while (true) {
                    System.out.print(((i == 0) ? "첫 번째" : "두 번째") + " 숫자를 입력하세요: ");

                    if(!sc.hasNextInt()) {
                        System.out.println("유효한 정수를 입력하세요.");
                        sc.next();
                        continue;
                    }

                    nums[i] = sc.nextInt();

                    if (nums[i] >= 0) {
                        break;
                    }
                    System.out.println("유효한 정수를 입력하세요.");
                }
            }

            boolean loop = true;

            while (loop) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);
                
                switch (operator) {
                    case '+', '-', '*', '/' -> {}
                    default -> {
                        System.out.println("유효한 연산자를 입력하세요.");
                        continue;
                    }
                }

                try {
                    double result = calculator.calculate(nums[0], nums[1], operator);
                    System.out.println("결과: " + result);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            System.out.println("현재 저장된 결과: " + calculator.getResults());
            System.out.println("가장 오래된 결과를 제거하겠습니까? (y/n)");
            if (sc.next().equals("y")) {
                calculator.removeResults();
                System.out.println("가장 오래된 결과가 제거되었습니다.");
            } else {
                System.out.println("제거하지 않고 넘어갑니다.");
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                break;
            }
        }
    }    
}
