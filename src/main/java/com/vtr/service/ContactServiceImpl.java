package com.vtr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtr.model.Contact;
import com.vtr.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public String Save(Contact c) {
		Contact savedContact=this.contactRepo.save(c);
		return "Contact Saved";
	}

	@Override
	public String update(Contact c) {
		try {
        Contact contact=this.contactRepo.getById(c.getContactId());
        contact.setContactName(c.getContactName());
        contact.setEmail(c.getEmail());
        contact.setPhno(c.getPhno());
        Contact updatedContact=this.contactRepo.save(contact);
        
		}catch(Exception e) {
			return "contact with given Id not exists";
		}
        
		return "Contact updated";
	}

	@Override
	public Contact getContactById(Integer id) {
		
		return this.contactRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Contact> getAllContacts() {
		return this.contactRepo.findAll();
	}

	@Override
	public String deleteById(Integer Id) {
		if(this.contactRepo.existsById(Id)) {
		  this.contactRepo.deleteById(Id);
		}else {
			return "Contact does not exists";
		}
		return "Contact deleted";
	}


}
