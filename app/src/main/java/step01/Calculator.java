package step01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];

        System.out.println("양의 정수 계산기");
        System.out.println("두 개의 양의 정수 및 사칙연산기호 (+, -, *, /)를 입력하면 계산합니다.");

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
    }
}