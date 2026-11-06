package step03;

import java.util.ArrayList;

public class ArithmeticCalculator {

    private ArrayList<Double> results = new ArrayList<>();

    public double calculate(int num1, int num2, char operator) {
        OperatorType operatorType = switch (operator) {
            case '+' -> OperatorType.ADD;
            case '-' -> OperatorType.SUB;
            case '*' -> OperatorType.MUL;
            case '/' -> OperatorType.DIV;
            default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        };

        double result = switch (operatorType) {
            case ADD -> num1 + num2;
            case SUB -> num1 - num2;
            case MUL -> num1 * num2;
            case DIV -> {
                if (num2 != 0) {
                    yield (double) num1 / num2;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
            }
        };
        results.add(result);
        return result;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}