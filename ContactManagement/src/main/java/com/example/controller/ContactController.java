package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Contact;
import com.example.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/contact")
	public Contact insertContact(@RequestBody Contact contact) {
		Contact savedContact = contactService.saveContact(contact);
		return savedContact;

	}

	@GetMapping("/getcontact")
	public List<Contact> fetchContactList() {
		return contactService.fetchContactList();
	}
	@GetMapping("/contact/{id}")
	public Optional<Contact> getContactId(@PathVariable("id") int id) {
		return contactService.findById(id);
}
}
