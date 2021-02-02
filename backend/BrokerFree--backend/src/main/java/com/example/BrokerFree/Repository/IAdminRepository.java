package com.example.BrokerFree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BrokerFree.Model.Admin;


public interface IAdminRepository extends JpaRepository<Admin, String> {

	
}
