package step03;

// 사칙연산 연산자를 정의하는 Enum 클래스
public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char operator;  // 연산자 문자 저장 변수

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    // 연산자 문자를 Enum 타입으로 변환하는 메서드
    public static OperatorType charToOperatorType(char operator) {
        return switch (operator) {
            case '+' -> ADD;
            case '-' -> SUB;
            case '*' -> MUL;
            case '/' -> DIV;
            default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        };
    }
}