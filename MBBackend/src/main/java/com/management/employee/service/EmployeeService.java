package com.management.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.management.employee.common.TokenManager;
import com.management.employee.entity.Employee;
import com.management.employee.entity.ManagerEntiry;
import com.management.employee.entity.SubscriptionEntity;
import com.management.employee.modal.APIResponse;
import com.management.employee.modal.CustomException;
import com.management.employee.modal.EmployeeRequest;
import com.management.employee.modal.Login;
import com.management.employee.modal.ManagerRequest;
import com.management.employee.modal.PaymentRequest;
import com.management.employee.modal.StripePaymentResponse;
import com.management.employee.modal.SubscriptionResponse;
import com.management.employee.modal.UserResponse;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.repository.ManagerRepository;
import com.management.employee.repository.StripePaymentRepository;
import com.management.employee.repository.SubscriptionRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private StripePaymentRepository repo;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	
	@Override
	public UserResponse login(Login login) throws Exception {
		UserResponse response = new UserResponse();
		Optional<ManagerEntiry> loginResponse= managerRepository.findByEmail(login.getUsername());
		if(loginResponse.isPresent()) {
			ManagerEntiry logindetail=loginResponse.get();
			if(logindetail.getEmail().equals(login.getUsername()) && logindetail.getPassword().equals(login.getPassword())) {
				BeanUtils.copyProperties(logindetail, response);
				String token = TokenManager.issueToken(logindetail, 30);
				response.setToken(token);
			}else{
				 throw new CustomException("Login Failed !");
			}
		}else {
			 throw new CustomException("please try again !");
		}
        return response;
	}
	
	
	@Override
	public APIResponse<String> addManager(@Valid ManagerRequest request) {
		ManagerEntiry manager = new ManagerEntiry();
		Optional<ManagerEntiry> logindetail= managerRepository.findByEmail(request.getEmail());
		if(logindetail.isPresent())
		{
		       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("User Alreaddy Exists").createAPIResponse();

		}
			//Add Manager
			BeanUtils.copyProperties(request, manager);
			managerRepository.save(manager);
	       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("Form submitted successfully").createAPIResponse();
	}

	
	@Override
	public APIResponse<String> save(EmployeeRequest employeeDto, String authToken)  throws Exception{
		Employee employee = new Employee();
		if (employeeDto.getId() == 0) {
			//Add Employee
			BeanUtils.copyProperties(employeeDto, employee);
			repository.save(employee);
		       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("Employee Added successfully").createAPIResponse();

		} else {
			//update Employee
			BeanUtils.copyProperties(employeeDto, employee);
			repository.save(employee);
		       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("Employee Updated successfully").createAPIResponse();

		}
	}

	@Override
	public APIResponse<List<EmployeeRequest>> findAll(String authToken)  throws Exception{
		List<Employee> employee = new ArrayList<Employee>();
		employee = (List<Employee>) repository.findAll();
		List<EmployeeRequest> employeeDto = new ArrayList<EmployeeRequest>();
		for (Employee e : employee) {
			EmployeeRequest dto = new EmployeeRequest();
			BeanUtils.copyProperties(e, dto);
			employeeDto.add(dto);
		}
        return new APIResponse.APIResponseBuilder<>().setCode(200).setSuccess(true).setData(employeeDto).createAPIResponse();
	}

	@Override
	public  APIResponse<EmployeeRequest>  findEmpById(long id, String authToken)  throws Exception{
		Employee employee = repository.findById(id).get();
		EmployeeRequest response = new EmployeeRequest();
		BeanUtils.copyProperties(employee, response);
        return new APIResponse.APIResponseBuilder<>().setCode(200).setSuccess(true).setData(response).createAPIResponse();
	}

	@Override
	public APIResponse<String> delete(long id, String authToken) throws Exception {
		int userId = TokenManager.getUser(authToken);
		repository.delete(repository.findById(id).get());
	       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("Deleted successfully").createAPIResponse();
	}

	@Override
	public APIResponse<String> stripeToken(PaymentRequest request, String authToken) throws Exception {
        Stripe.apiKey = "sk_test_51Iaed1SGQDLKU2L0ZTkQOzwbQA2zNRAq00GEON0MYMZZ8SOuOGkvVDIcUaq3AxK5W8eFILcIKWX7Boh0VnCtjUWN00ldIEKtQP";
		int userId = TokenManager.getUser(authToken);
        Map<String, Object> chargeParams = new HashMap();
        chargeParams.put("amount", (int)(request.getAmount() * 100));
        chargeParams.put("currency", "inr");
        chargeParams.put("source", request.getToken());
        
        try {
			Charge charge = Charge.create(chargeParams);
			StripePaymentResponse entity = new StripePaymentResponse();
			entity.setManagerId(Long.valueOf(userId));
			entity.setSubscriptionId(request.getSubscriptionId());
			entity.setAmount(charge.getAmount());
			entity.setCust_id(charge.getId());
			entity.setSucess(charge.getStatus());
			entity.setTranasctionId(charge.getBalanceTransaction());
			String jsonString = new com.google.gson.Gson().toJson(charge);
			entity.setCharge(jsonString);
			entity.setStatus(true);
//			Optional<List<StripePaymentResponse>> subscriptionResponse = repo.findByManagerIdAndStatusOrderByIdDesc(Long.valueOf(userId),true);
//			if(subscriptionResponse.isPresent()) {
//				subscriptionResponse.get().stream().forEach(user -> {
//					user.setStatus(false);
//					repo.save(user);
//				});
//			}
			repo.save(entity);		

			return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData(charge.getReceiptUrl()).createAPIResponse();
		} catch (StripeException e) {
//			e.printStackTrace();
		       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("payment Faild").createAPIResponse();

		}

	}


	@Override
	public APIResponse<List<SubscriptionResponse>> fetchAllSubscription(String authToken) throws Exception {
		
		int userId = TokenManager.getUser(authToken);
		System.out.println(userId+"--------------");
		List<SubscriptionEntity> response =  subscriptionRepository.findAll();
		List<SubscriptionResponse> res = new ArrayList<SubscriptionResponse>();
		Optional<List<StripePaymentResponse>> subscriptionResponse = repo.findByManagerIdAndStatusOrderByIdDesc(Long.valueOf(userId),true);
		for (SubscriptionEntity e : response) {
			SubscriptionResponse dto = new SubscriptionResponse();
			BeanUtils.copyProperties(e, dto);
			if(subscriptionResponse.isPresent()) {
				subscriptionResponse.get().stream().forEach(user -> {
					if(user.getSubscriptionId()==dto.getId()) {
						dto.setStatus(true);
					}
				});
			}
//				user.setStatus(false);
//				repo.save(user);
//			});
//			if(subscriptionResponse.isPresent() && subscriptionResponse.get().get(0).getSubscriptionId()==e.getId()) {
//				dto.setStatus(true);
//			}
			res.add(dto);
		}
        return new APIResponse.APIResponseBuilder<>().setCode(200).setSuccess(true).setData(res).createAPIResponse();
	}


	@Override
	public APIResponse<String> unSubscribe(Long id, String authToken) throws Exception {
			int userId = TokenManager.getUser(authToken);

			Optional<List<StripePaymentResponse>> subscriptionResponse = repo.findByManagerIdAndSubscriptionIdAndStatusOrderByIdDesc(Long.valueOf(userId),id,true);
			if(subscriptionResponse.isPresent()) {
				subscriptionResponse.get().get(0).setStatus(false);
				repo.save(subscriptionResponse.get().get(0));
		       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("Unsubscribed successfully").createAPIResponse();
		
			}
	       return new APIResponse.APIResponseBuilder<>().setCode(HttpStatus.OK.value()).setSuccess(true).setData("Unsubscribed Fail Please tru again").createAPIResponse();
	}

}
