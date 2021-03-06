package de.wwu.acse.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import de.wwu.acse.rest.dto.AddRequest;
import de.wwu.acse.rest.dto.AddResponse;
import de.wwu.acse.rest.dto.MyNumber;
import de.wwu.acse.rest.dto.MySum;
import de.wwu.acse.rest.service.AdderService;

@RestController // @Controller + @ResponseBody for @RequestMapping-methods (like @GetMapping(...))
public class RestAdderController {
	@Autowired
	private AdderService adderService;
	
	/*
	// With usual @Controller annotation: 
	@GetMapping("/add0")
	public String addNumbers0(
			Model model,
			int n1,
			int n2) {
		MySum result = adderService.add(new MyNumber(n1), new MyNumber(n2));
		
		model.addAttribute("sum", result);
		
		return "sum"; // Return to the "sum"-view in usual @Controller
	}
	*/
	
	@GetMapping("/add1")
	public MySum addNumbers1(
			int n1, 
			int n2) {
		MyNumber mn1 = new MyNumber();
		MyNumber mn2 = new MyNumber();
		mn1.setVal(n1);
		mn2.setVal(n2);
		MySum sum = adderService.add(mn1, mn2);
		return sum; // Automatic conversion to JSON
	}
	
	@PostMapping("/postAdd")
	public AddResponse addNumbers(@RequestBody AddRequest addRequest) {
		MyNumber mn1 = new MyNumber();
		MyNumber mn2 = new MyNumber();
		mn1.setVal(addRequest.getN1());
		mn2.setVal(addRequest.getN2());
		
		MySum sum = adderService.add(mn1, mn2);
		
		AddResponse addResponse = new AddResponse();
		addResponse.setSum(sum);
		
		return addResponse;
	}
	
	
	@GetMapping("/add2")
	public ModelAndView addNumbers2(
			int n1, 
			int n2) {
		// This can be called via the browser, for instance with http://localhost:8080/add2?n1=416&n2=3
		MyNumber mn1 = new MyNumber();
		MyNumber mn2 = new MyNumber();
		mn1.setVal(n1);
		mn2.setVal(n2);
		MySum sum = adderService.add(mn1, mn2);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sum.html");
		mav.addObject("result", sum);
		return mav; // Comparable to @Controller
	}
}
