package de.wwu.acse.rest.dto;

public class MySum {

    protected MyNumber n1;
    protected MyNumber n2;
    protected int sum;

    public MyNumber getN1() {
        return n1;
    }

    public void setN1(MyNumber value) {
        this.n1 = value;
    }

    public MyNumber getN2() {
        return n2;
    }

    public void setN2(MyNumber value) {
        this.n2 = value;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int value) {
        this.sum = value;
    }
    
    @Override
    public String toString() {
    	return "MySum{n1=" + n1 + ", n2=" + n2 + ", sum=" + sum + "}";
    }
}