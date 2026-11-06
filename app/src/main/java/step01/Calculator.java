package step01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];

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
            char operator = ' ';

            while (loop) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.next().charAt(0);

                double result = 0;
                switch (operator) {
                    case '+':
                        loop = false;
                        result = nums[0] + nums[1];
                        break;
                    case '-':
                        loop = false;
                        result = nums[0] - nums[1];
                        break;
                    case '*':
                        loop = false;
                        result = nums[0] * nums[1];
                        break;
                    case '/':
                        if (nums[1] != 0) {
                            loop = false;
                            result = (double)nums[0] / nums[1];
                            break;
                        } else {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                    default:
                        System.out.println("유효한 연산자를 입력하세요.");
                        continue;
                }
                System.out.println("결과: " + result);
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                break;
            }
        }
    }
}