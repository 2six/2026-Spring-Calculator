package step03;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] nums = new double[2];
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        System.out.println("실수 계산기");
        System.out.println("두 개의 실수 및 사칙연산기호 (+, -, *, /)를 입력하면 계산합니다.");

        while(true) {
            for(int i = 0; i < nums.length; i++) {  // 두 개의 실수 입력
                System.out.print(((i == 0) ? "첫 번째" : "두 번째") + " 숫자를 입력하세요: ");
                nums[i] = sc.nextDouble();
            }

            boolean loop = true;

            while (loop) {  // 연산자 입력 및 검증 후 계산 수행
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
                    // 계산 실행 및 결과 출력
                    double result = calculator.calculate(nums[0], nums[1], operator);
                    System.out.printf("결과: %.2f\n", result);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            // 현재 저장된 결과 출력
            System.out.print("현재 저장된 결과: [");
            ArrayList<Double> list = calculator.getResults();
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%.2f", list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            // 가장 오래된 결과 제거
            System.out.println("가장 오래된 결과를 제거하겠습니까? (y/n)");
            if (sc.next().equals("y")) {
                calculator.removeResults();
                System.out.println("가장 오래된 결과가 제거되었습니다.");
            } else {
                System.out.println("제거하지 않고 넘어갑니다.");
            }

            // 기준값보다 큰 결과 조회
            System.out.println("특정 값보다 큰 결과를 조회하시겠습니까? (y/n)");
            if (sc.next().equals("y")) {
                System.out.println("기준 값을 입력하세요:");
                double baseNum = sc.nextDouble();
                ArrayList<Double> greaterResults = calculator.getResultsGreaterThan(baseNum);
                System.out.print("기준보다 큰 결과들: [");
                for (int i = 0; i < greaterResults.size(); i++) {
                    System.out.printf("%.2f", greaterResults.get(i));
                    if (i < greaterResults.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }

            // 프로그램 종료 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                break;
            }
        }
    }    
}
