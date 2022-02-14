package de.wwu.acse.rest.service;

import org.springframework.stereotype.Service;

import de.wwu.acse.rest.dto.MyNumber;
import de.wwu.acse.rest.dto.MySum;

@Service
public class StdAdderService implements AdderService {

	@Override
	public MySum add(MyNumber n1, MyNumber n2) {
		MySum result = new MySum();
		result.setN1(n1);
		result.setN2(n2);
		result.setSum(n1.getVal() + n2.getVal());
		return result;
	}
	
}
