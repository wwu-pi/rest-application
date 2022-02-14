package de.wwu.acse.rest.dto;

public class AddRequest {

    protected int n1;
    protected int n2;

    public int getN1() {
        return n1;
    }

    public void setN1(int value) {
        this.n1 = value;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int value) {
        this.n2 = value;
    }
    
    @Override
    public String toString() {
    	return "AddRequest{n1=" + n1 + ", n2=" + n2 + "}";
    }

}
