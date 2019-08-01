package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("rest/employee")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	//---------------------------------------------------------------------------------------------------	
			@PostMapping("/insert")
			public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
				ResponseEntity<String> resp=null;
				try {
				Integer id=service.saveEmployee(employee);
				resp=new ResponseEntity<String>("Employee '"+id+"' is created",HttpStatus.OK);
				}catch(Exception e) {
					resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
				}
				return resp;
			}
		//-----------------------------------------------------------------------------------------------------	

			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer eid){
				ResponseEntity<String> resp=null;
				try {
				service.deleteEmployee(eid);
				resp=new ResponseEntity<String>("Employee '"+eid+"' is deleted",HttpStatus.OK);
				}catch(Exception e) {
					resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
				}
				return resp;
			}
			//-----------------------------------------------------------------------------------------------------
			@GetMapping("/all")
			public ResponseEntity<?> getAllEmployeeInfo(){
				ResponseEntity<?> resp=null;
				try {
				List<Employee> list=service.getAllEmployees();
				if(list!=null && !list.isEmpty())
					resp=new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
				else
					resp=new ResponseEntity<String>("No Data Found",HttpStatus.OK);

			} catch (Exception e) {
				resp=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
			return resp;
			}
		//-----------------------------------------------------------------------------------------------------	
			@PutMapping("/update")
			public ResponseEntity<?> updateEmployee() {
				return new ResponseEntity<String>("Under development", HttpStatus.OK);
			}


}
