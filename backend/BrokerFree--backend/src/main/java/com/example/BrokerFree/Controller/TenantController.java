package com.example.BrokerFree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Service.TenantService;

@RestController
public class TenantController {
	@Autowired
	private TenantService tService;
	  @CrossOrigin(origins="http://localhost:4200")
		@PostMapping("/registerTenant")
		public ResponseEntity<?> m2(@RequestBody Tenant tenant) {
			System.out.println("inside register tenant");
			tService.registerTenant(tenant);

			return new ResponseEntity<Tenant>(tenant, HttpStatus.OK);
		}
	  @CrossOrigin(origins="http://localhost:4200")
	    @PostMapping("/loginTenant")
	    public Tenant tenantLogin(@RequestBody Tenant t)throws Exception{
	   	 String tempEmail=t.getTemail();
	   	 String tempPassword=t.getTpassword();
	   	 
	   	 Tenant tenantobj= null;
	   	 if(tempEmail !=null && tempPassword!=null) {
	   		 tenantobj=tService.fetchTenantByEmailAndPassword(tempEmail, tempPassword);
	   	 }
	   	 if(tenantobj == null) {
	   		 throw new Exception("Wrong credentials");
	   	 }
	   	 return tenantobj;
	    }

}
