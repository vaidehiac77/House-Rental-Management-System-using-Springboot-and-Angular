package com.example.BrokerFree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Service.OwnerService;
@RestController
public class OwnerController {
	
	@Autowired
	private OwnerService oService;
    @CrossOrigin(origins="http://localhost:4200")
    
	@PostMapping("/registerOwner")
	public ResponseEntity<?> m2(@RequestBody Owner owner) {
		System.out.println("inside register Owner");
		oService.registerOwner(owner);

		return new ResponseEntity<Owner>(owner, HttpStatus.OK);
	}
    
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/loginOwner")
    public Owner ownerLogin(@RequestBody Owner o)throws Exception{
   	 String tempEmail=o.getOemail();
   	 String tempPassword=o.getOpassword();
   	 
   	 Owner ownerobj= null;
   	 if(tempEmail !=null && tempPassword!=null) {
   		 ownerobj=oService.fetchOwnerByEmailAndPassword(tempEmail, tempPassword);
   	 }
   	 if(ownerobj == null) {
   		 throw new Exception("Wrong credentials");
   	 }
   	 return ownerobj;
    }
	
	

}
