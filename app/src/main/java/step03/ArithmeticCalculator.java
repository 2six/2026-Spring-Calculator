package step03;

import java.util.ArrayList;
import java.util.stream.Collectors;

//  제네릭을 활용한 사칙연선 계산기
public class ArithmeticCalculator<T extends Number> {

    private ArrayList<T> results = new ArrayList<>();

    // 두 숫자와 연산자를 받아 계산을 수행하고 결과를 저장후 반환하는 메서드
    public T calculate(T num1, T num2, char operator) {
        // 문자를 OperatorType Enum으로 변환
        OperatorType operatorType = OperatorType.charToOperatorType(operator);
        

        // 사칙연산을 위해 double 타입으로 변환
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        double result = 0;

        switch (operatorType) {
            case ADD -> result = n1 + n2;
            case SUB -> result = n1 - n2;
            case MUL -> result = n1 * n2;
            case DIV -> {
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    // 0으로 나누는 경우 예외 처리
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
            }
        }

        T finalResult;

        // 결과를 원래 타입에 맞게 형변환 (박싱)
        if (num1 instanceof Integer) {
            finalResult = (T) Integer.valueOf((int) result);
        } else if (num1 instanceof Long) {
            finalResult = (T) Long.valueOf((long) result);
        } else if (num1 instanceof Double) {
            finalResult = (T) Double.valueOf(result);
        } else {
            throw new IllegalArgumentException("유효하지 않은 타입입니다.");
        }

        results.add(finalResult);
        return finalResult;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    public void setResults(ArrayList<T> results) {
        this.results = results;
    }

    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    // 전달받은 기준값보다 큰 결과들만 필터링하여 리스트로 반환
    public ArrayList<T> getResultsGreaterThan(T baseNum) {
        double baseValue = baseNum.doubleValue();

        return results.stream()
                .filter(num -> num.doubleValue() > baseValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}