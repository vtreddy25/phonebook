package com.vtr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtr.model.Contact;
import com.vtr.service.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactService;
	
	@PostMapping("/saveContact")
	public ResponseEntity<String> save(@RequestBody Contact contact){
		
		return new ResponseEntity<>(this.contactService.Save(contact),HttpStatus.OK);
	}
	
	@PostMapping("/updateContact")
	public ResponseEntity<String> update(@RequestBody Contact contact){
		
		return new ResponseEntity<>(this.contactService.update(contact),HttpStatus.OK);
	}
	
	@GetMapping("/getContact/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer id){
		return new ResponseEntity<>(this.contactService.getContactById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllContacts")
	public ResponseEntity<List<Contact>> getAllContacts(){
		
		return new ResponseEntity<List<Contact>>(this.contactService.getAllContacts(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		return new ResponseEntity<>(this.contactService.deleteById(id),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
