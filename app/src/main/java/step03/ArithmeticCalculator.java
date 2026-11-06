package step03;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private ArrayList<T> results = new ArrayList<>();

    public T calculate(T num1, T num2, char operator) {
        OperatorType operatorType = OperatorType.charToOperatorType(operator);
        
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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
            }
        }

        T finalResult;

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

    public ArrayList<T> getResultsGreaterThan(T baseNum) {
        double baseValue = baseNum.doubleValue();

        return results.stream()
                .filter(num -> num.doubleValue() > baseValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}