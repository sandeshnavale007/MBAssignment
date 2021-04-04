package com.management.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.employee.modal.APIResponse;
import com.management.employee.modal.ApiResponseError;
import com.management.employee.modal.EmployeeRequest;
import com.management.employee.modal.Login;
import com.management.employee.modal.ManagerRequest;
import com.management.employee.modal.PaymentRequest;
import com.management.employee.modal.SubscriptionResponse;
import com.management.employee.modal.UserResponse;
import com.management.employee.modal.requestForId;
import com.management.employee.service.IEmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

 /**
 * @author Sandesh
 * Login Api for manager
 */
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody Login login) {
		APIResponse<UserResponse> apiResponse = null;
		try {
			apiResponse = new APIResponse<>();
			UserResponse user = employeeService.login(login);
			apiResponse.setData(user);
			apiResponse.setCode(200);
		}catch (Exception e) {
			ApiResponseError error = new ApiResponseError(0, null);
			error.setMessage("Username Password Does not match");;
			error.setCode(401);
			return ResponseEntity.status(error.getCode()).body(error);
		}
		return ResponseEntity.status(200).body(apiResponse);
	}

 /**
 * @author Sandesh
 * Create Manager
 */
	
	@PostMapping("/addManager")
	public ResponseEntity<APIResponse<String>> addManager(@Valid @RequestBody ManagerRequest request) {
		return ResponseEntity.ok(employeeService.addManager(request));
	}

 /**
 * @author Sandesh
 * Create Employee & Update Employee
 * @throws Exception 
 */
			
	@PostMapping("/")
	public ResponseEntity<APIResponse<String>> save(@Valid @RequestBody EmployeeRequest employeedto,@RequestHeader(value = "Authorization") String authToken) throws Exception {
		System.out.println("---------"+authToken); 
		return ResponseEntity.ok(employeeService.save(employeedto,authToken));
	}
// /**
// * @author Sandesh
// * Update Employee
// * @throws Exception 
// */
//	@PutMapping("/")
//	public ResponseEntity<APIResponse<String>>  update(@RequestBody EmployeeRequest employeedto,@RequestHeader(value = "Authorization") String authToken) throws Exception {
//		 return ResponseEntity.ok(employeeService.save(employeedto,authToken));
//	}
	 /**
	 * @author Sandesh
	 * Get All Employee List
	 * @throws Exception 
	 */
	@GetMapping("/")
	public ResponseEntity<APIResponse<List<EmployeeRequest>>> findAll(@RequestHeader(value = "Authorization") String authToken) throws Exception {
		return ResponseEntity.ok(employeeService.findAll(authToken));

	}
	 /**
	 * @author Sandesh
	 * Get Employee of perticular id
	 * @throws Exception 
	 */
	@PostMapping("/getEmployeeById")
	public ResponseEntity<APIResponse<EmployeeRequest>> findById(@RequestBody requestForId id,@RequestHeader(value = "Authorization") String authToken) throws Exception {
		return ResponseEntity.ok(employeeService.findEmpById(id.getId(),authToken));

	}
	 /**
	 * @author Sandesh
	 * Delete Employee
	 * @throws Exception 
	 */
	@PostMapping("/removeEmployee")
	public  ResponseEntity<APIResponse<String>> delete(@RequestBody requestForId id,@RequestHeader(value = "Authorization") String authToken) throws Exception {
		return ResponseEntity.ok(employeeService.delete(id.getId(),authToken));

	}
	 /**
	 * @author Sandesh
	 * Get Subscription list
	 * @throws Exception 
	 */
	@GetMapping("/subscription")
	public  ResponseEntity<APIResponse<List<SubscriptionResponse>>> fetchAllSubscription(@RequestHeader(value = "Authorization") String authToken) throws Exception {
		System.out.println(authToken+"-----------");
		return ResponseEntity.ok(employeeService.fetchAllSubscription(authToken));

	}
	 /**
	 * @author Sandesh
	 * Unsubscribe
	 * @throws Exception 
	 */
	@PostMapping("/unsubscripbed")
	public ResponseEntity<APIResponse<String>> unSubscribe(@RequestBody requestForId id,@RequestHeader(value = "Authorization") String authToken) throws Exception {
		return ResponseEntity.ok(employeeService.unSubscribe(id.getId(),authToken));

	}
	 /**
	 * @author Sandesh
	 * Stripe Payment GAitway Api
	 * @throws Exception 
	 */
	@PostMapping("/stripeToken")
	public ResponseEntity<APIResponse<String>> save( @RequestBody PaymentRequest request,@RequestHeader(value = "Authorization") String authToken) throws Exception {
		return ResponseEntity.ok(employeeService.stripeToken(request,authToken));
	}
}
