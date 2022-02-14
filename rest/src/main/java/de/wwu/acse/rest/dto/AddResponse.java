package de.wwu.acse.rest.dto;


public class AddResponse {

    protected MySum sum;

    public MySum getSum() {
        return sum;
    }

    public void setSum(MySum value) {
        this.sum = value;
    }

    @Override
    public String toString() {
    	return "AddResponse{sum=" + sum + "}";
    }
    
}
