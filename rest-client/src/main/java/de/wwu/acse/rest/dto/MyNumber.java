package de.wwu.acse.rest.dto;

public class MyNumber {

    protected int val;

    public int getVal() {
        return val;
    }

    public void setVal(int value) {
        this.val = value;
    }
    
    @Override
    public String toString() {
    	return "MyNumber{val=" + val + "}";
    }

}