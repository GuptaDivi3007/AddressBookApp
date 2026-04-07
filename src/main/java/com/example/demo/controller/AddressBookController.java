package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Contact;
import com.example.demo.service.AddressBookService;
import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired
    AddressBookService service;

    
	 @GetMapping
	 public String welcomeMessage() {
	      return "Welcome to Address Book Program";
	 }
	 @PostMapping("/add")
	    public Contact addContact(@RequestBody Contact contact) {
	        return service.addContact(contact);
	  }
	 @GetMapping("/all")
	 public List<Contact> getAllContacts() {
	     return service.getAllContacts();
	 }
	 @PutMapping("/edit/{name}")
	    public Contact editContact(@PathVariable("name") String firstName,
	                               @RequestBody Contact contact) {

	        return service.updateContact(firstName, contact);
	    }
	 @DeleteMapping("/delete/{name}")
	 public String deleteContact(@PathVariable("name") String firstName) {
	     return service.deleteContact(firstName);
	 }
}
