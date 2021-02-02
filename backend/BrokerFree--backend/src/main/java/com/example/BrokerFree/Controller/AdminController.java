package com.example.BrokerFree.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Model.Property;
import com.example.BrokerFree.Service.OwnerService;
import com.example.BrokerFree.Service.PropertyService;
import com.example.BrokerFree.Service.TenantService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/admin",produces = "application/json")
public class AdminController 
{
   
	        // dependency : service layer i/f
			@Autowired
			private OwnerService ownerService;
			
			@Autowired
			private TenantService tenantService;
			
			@Autowired
			private PropertyService propertyService;
			
		
			
			public AdminController() 
			{
				System.out.println("In constructor of............"+getClass().getName());
			}
			
			//RESTful/API  end point
			// add a request handling method to return representation of list of available owner 
			// get list of all owners
			@CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/listOwners", method = RequestMethod.GET)
			public ResponseEntity<?> listAllOwners()
			{
				System.out.println("in list all owners");
			     List<Owner> owners=ownerService.getAllOwners();
			     // check if list is empty
			      if(owners.isEmpty())
			    	 return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			    //for non empty list
			         return new ResponseEntity<>(owners,HttpStatus.OK);
			}
	
		       	//RESTful/API  end point
				// add a request handling method to return representation of list of available owner 
				// get list of all tenants
				
			@CrossOrigin(origins="http://localhost:4200")
				 @RequestMapping(value = "/listTenants", method = RequestMethod.GET)
				public ResponseEntity<?> listAllTenants()
				{
					System.out.println("in list all tenants");
				     List<Tenant> tenants=tenantService.getAllTenants();
				     // check if list is empty
				      if(tenants.isEmpty())
				    	 return new ResponseEntity<> (HttpStatus.NO_CONTENT);
				    //for non empty list
				         return new ResponseEntity<>(tenants,HttpStatus.OK);
				}
				
			 
			
					
					
					
				    //RESTful/API  end point
					// add a request handling method to return representation of list of available owner 
					// get list of all properties
					
			@CrossOrigin(origins="http://localhost:4200")
					 @RequestMapping(value = "/listProperties", method = RequestMethod.GET)
					public ResponseEntity<?> listAllProperties()
					{
						System.out.println("in list all properties");
					     List<Property> properties=propertyService.getAllProperty();
					     if(properties.isEmpty())
					    	 return new ResponseEntity<> (HttpStatus.NO_CONTENT);
					
					    return new ResponseEntity<>(properties,HttpStatus.OK);
					}
					
					//add REST end point to delete owner details
						//@DeleteMapping("/{ownerId}")
			@CrossOrigin(origins="http://localhost:4200")
						 @RequestMapping(method = RequestMethod.DELETE , value="/deleteOwner/{ownerId}")
						public void deleteOwnerDetails(@PathVariable int ownerId) 
						 {
							System.out.println("in delete owner details " + ownerId);
							try 
							{
								ownerService.deleteOwnerDetails(ownerId);
								
							}
							
							catch (RuntimeException e)
							{
								System.out.println("error in controller " + e);
							}
						}
						
						
				
}
