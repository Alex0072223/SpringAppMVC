package Calc;

import java.math.BigDecimal;

public class Calc {
    private String firstNum = "0";
    private String secondNum = "0";
    private char operator = '+';
    private String result;

    public String getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(String firstNum) {
        this.firstNum = firstNum;
    }

    public String getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(String secondNum) {
        this.secondNum = secondNum;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void calc() {
        BigDecimal firstnum = new BigDecimal(this.firstNum);
        BigDecimal secondnum = new BigDecimal(this.secondNum);
        switch (this.operator) {
            case '+':
                this.result = firstnum.add(secondnum).toString();
                break;
            case '-':
                this.result = firstnum.subtract(secondnum).toString();
                break;
            case '*':
                this.result = firstnum.multiply(secondnum).toString();
                break;
            case '/':
                if(secondnum.doubleValue()==0) {
                    throw new RuntimeException ("Делить на ноль нельзя");
                }else {
                    this.result = firstnum.divide(secondnum, 10,BigDecimal.ROUND_HALF_DOWN).toString();
                }

            default:
                break;
        }

    }


}