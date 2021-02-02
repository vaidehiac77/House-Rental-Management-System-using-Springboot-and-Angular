package com.example.BrokerFree.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Repository.IOwnerRepository;
@Service
@Transactional

public class OwnerService
{
	@Autowired
	private IOwnerRepository repo;
     public Owner registerOwner(Owner owner)
     {
    	 return repo.save(owner);
     }
	
	public Owner fetchOwnerByEmailAndPassword(String oemail,String opassword)
	{
		return repo.findByOemailAndOpassword(oemail,opassword);
	}

	public List<Owner> getAllOwners() {
			System.out.println(" Owner service impl class..."+repo.getClass().getName());
			return repo.findAll();
		}

			public void deleteOwnerDetails(int ownerId) {
			// check if owner exists : yes : delete , otherwise throw exception
			Optional<Owner> optional = repo.findById(ownerId);
			if (optional.isPresent())
				repo.deleteById(ownerId); //delete
			
		}

	
}
