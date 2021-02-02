
package com.example.BrokerFree.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="email",length = 50,unique = true,nullable = false)
	private String email;
	
	@Column(name="password",length = 50,nullable = false)
    private String password;
	
	public Admin()
	{
		super();
		System.out.println("In Admin constructor.................."+getClass().getName());
	}

	public Admin(String email, String password)
	{
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "Admin [email=" + email + ", password=" + password + "]";
	}
   
}	
	
	