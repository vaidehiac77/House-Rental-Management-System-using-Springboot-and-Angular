package com.example.BrokerFree.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tenant")
public class Tenant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
     private Integer tid;

	@Column
     private String tname;
	
	@Column
     private String temail;
	
	@Column
     private String tcontact;
	
	@Column
     private String tpassword;
	
	//@OneToMany(mappedBy = "tenant")
	//Set<ShortlistedProperty> sp;


	public Tenant(Integer tid, String tname, String temail, String tcontact, String tpassword) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.temail = temail;
		this.tcontact = tcontact;
		this.tpassword = tpassword;
	}
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public String getTcontact() {
		return tcontact;
	}
	public void setTcontact(String tcontact) {
		this.tcontact = tcontact;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	@Override
	public String toString() {
		return "Tenant [tid=" + tid + ", tname=" + tname + ", temail=" + temail + ", tcontact=" + tcontact
				+ ", tpassword=" + tpassword + "]";
	}
     
}
