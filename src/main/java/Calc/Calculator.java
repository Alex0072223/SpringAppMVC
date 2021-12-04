package Calc;

public class Calculator {

    public static final String USER_TABLE = "calc";

    private int idn;
    private double firstNumber;
    private double secondNumber;
    private double result;

    public Calculator(int idn, double firstNumber, double secondNumber, double result){
        this.idn = idn;
        this.firstNumber=firstNumber;
        this.secondNumber=secondNumber;
        this.result=result;
    }

    public Calculator(){}

    public int getIdn() {
        return idn;
    }

    public void setIdn(int idn) {
        this.idn = idn;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }





}
