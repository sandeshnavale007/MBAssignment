package com.management.employee.service;

import java.util.List;

import javax.validation.Valid;

import com.management.employee.modal.APIResponse;
import com.management.employee.modal.EmployeeRequest;
import com.management.employee.modal.Login;
import com.management.employee.modal.ManagerRequest;
import com.management.employee.modal.PaymentRequest;
import com.management.employee.modal.SubscriptionResponse;
import com.management.employee.modal.UserResponse;

public interface IEmployeeService {

	public APIResponse<String> save(EmployeeRequest employeeDto, String authToken) throws Exception;

	public APIResponse<List<EmployeeRequest>> findAll( String authToken) throws Exception;

	public APIResponse<EmployeeRequest> findEmpById(long id, String authToken) throws Exception;
	
	public APIResponse<String> delete(long id, String authToken) throws Exception;
	
	public UserResponse login(Login login) throws Exception;

	public APIResponse<String> stripeToken(PaymentRequest request, String authToken) throws Exception;

	public APIResponse<String>  addManager(@Valid ManagerRequest request);

	public APIResponse<List<SubscriptionResponse>> fetchAllSubscription(String authToken) throws Exception;

	public APIResponse<String> unSubscribe(Long id, String authToken) throws Exception;

}
