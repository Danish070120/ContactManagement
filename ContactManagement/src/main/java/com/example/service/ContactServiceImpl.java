package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact contact) {
		log.info("contact {}", contact);
		contact.getCntEmail().stream().forEach(cntEmail -> cntEmail.setContact(contact));
		contact.getCntAddress().stream().forEach(cntAddress -> cntAddress.setContact(contact));
		contact.getCntPhone().stream().forEach(cntPhone -> cntPhone.setContact(contact));
		contact.getCntSocial().stream().forEach(cntSocial -> cntSocial.setContact(contact));
		contactRepository.save(contact);
		return contact;
	}

	@Override
	public List<Contact> fetchContactList() {
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

}
