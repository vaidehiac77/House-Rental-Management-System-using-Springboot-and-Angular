package com.example.BrokerFree.Service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Repository.ITenantRepository;

@Service
@Transactional
public class TenantService {

	@Autowired
	private ITenantRepository repo;
	public Tenant registerTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return repo.save(tenant);
	}

	public Tenant fetchTenantByEmailAndPassword(String tempEmail, String tempPassword) {
		// TODO Auto-generated method stub
		return repo.findByTemailAndTpassword(tempEmail, tempPassword);
	}

		public List<Tenant> getAllTenants() {
		System.out.println(" Tenant service impl class..."+repo.getClass().getName());
		return repo.findAll();
		
	}


}
