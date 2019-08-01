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
import com.app.model.Student;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("rest/customer")
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	//---------------------------------------------------------------------------------------------------	
		@PostMapping("/insert")
		public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
			ResponseEntity<String> resp=null;
			try {
			Integer id=service.saveCustomer(customer);
			resp=new ResponseEntity<String>("Customer '"+id+"' is created",HttpStatus.OK);
			}catch(Exception e) {
				resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}
	//-----------------------------------------------------------------------------------------------------	

		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer cid){
			ResponseEntity<String> resp=null;
			try {
			service.deleteCustomert(cid);
			resp=new ResponseEntity<String>("Customer '"+cid+"' is deleted",HttpStatus.OK);
			}catch(Exception e) {
				resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}
		//-----------------------------------------------------------------------------------------------------
		@GetMapping("/all")
		public ResponseEntity<?> getAllCustomerInfo(){
			ResponseEntity<?> resp=null;
			try {
			List<Customer> list=service.getAllCustomer();
			if(list!=null && !list.isEmpty())
				resp=new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
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
		public ResponseEntity<?> updateCustomer() {
			return new ResponseEntity<String>("Under development", HttpStatus.OK);
		}

}
