package com.vtr.service;

import java.util.List;

import com.vtr.model.Contact;

public interface ContactService {

	public String Save(Contact c);
	
	public String update(Contact c);
	
	public Contact getContactById(Integer id);
	
	public List<Contact> getAllContacts();
	
	public String deleteById(Integer Id);
}
