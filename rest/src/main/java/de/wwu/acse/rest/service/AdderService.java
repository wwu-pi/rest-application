package de.wwu.acse.rest.service;

import de.wwu.acse.rest.dto.MyNumber;
import de.wwu.acse.rest.dto.MySum;

public interface AdderService {
	
	MySum add(MyNumber n1, MyNumber n2);
	
}
