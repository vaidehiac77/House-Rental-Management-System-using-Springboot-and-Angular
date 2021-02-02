package com.example.BrokerFree.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="oid")
	private Integer oid;
	
	//@NotNull
	@Column(name="oname")
	private String oname;
	
	//@NotNull
	@Column(name="oemail")
	private String oemail;
	
	//@NotNull
	@Column(name="ocontact")
	private String ocontact;
	
	//@NotNull
	@Column(name="opassword")
	private String opassword;
	
	 //@JsonManagedReference
	  @JsonIgnoreProperties("owner")
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	  private Set<Property> properties;
	
    public Owner()
    {
    	System.out.println("In Owners Constructor:"+getClass().getName());
    }

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	public String getOcontact() {
		return ocontact;
	}

	public void setOcontact(String ocontact) {
		this.ocontact = ocontact;
	}

	public String getOpassword() {
		return opassword;
	}

	public void setOpassword(String opassword) {
		this.opassword = opassword;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public Owner(Integer oid, String oname, String oemail, String ocontact, String opassword,
			Set<Property> properties) {
		super();
		this.oid = oid;
		this.oname = oname;
		this.oemail = oemail;
		this.ocontact = ocontact;
		this.opassword = opassword;
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Owner [oid=" + oid + ", oname=" + oname + ", oemail=" + oemail + ", ocontact=" + ocontact
				+ ", opassword=" + opassword + ", properties=" + properties + "]";
	}

	

	
	
}
