package com.cg.sprint.validation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.sprint.exception.AdminNotFoundException;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;

@RestControllerAdvice
public class ValidationHandel {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> invalidArguments(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		 ex.getBindingResult().getFieldErrors().forEach(error->{
			errors.put(error.getField(),error.getDefaultMessage());
			});
		return errors;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(AdminNotFoundException.class)
	public LinkedHashMap<String, String> handleAdminNotFound(AdminNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("Admin Id",e.getMessage());
		return errors;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CabNotFoundException.class)
	public LinkedHashMap<String, String> handleCabNotFound(CabNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("Cab Id",e.getMessage());
		return errors;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public LinkedHashMap<String, String> handleCustomerNotFound(CabNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("Custoner Id",e.getMessage());
		return errors;
	}
}
