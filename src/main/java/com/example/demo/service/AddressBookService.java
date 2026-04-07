package com.example.demo.service;
import java.util.List;



import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressBookService {

    @Autowired
    ContactRepository repository;

    public Contact addContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }
    public Contact updateContact(String firstName, Contact newContact) {

        Contact existingContact = repository.findById(firstName).orElse(null);

        if(existingContact != null) {

            existingContact.setLastName(newContact.getLastName());
            existingContact.setAddress(newContact.getAddress());
            existingContact.setCity(newContact.getCity());
            existingContact.setState(newContact.getState());
            existingContact.setZip(newContact.getZip());
            existingContact.setPhoneNumber(newContact.getPhoneNumber());
            existingContact.setEmail(newContact.getEmail());

            return repository.save(existingContact);
        }

        return null;
    }
    public String deleteContact(String firstName) {

        if(repository.existsById(firstName)) {
            repository.deleteById(firstName);
            return "Contact deleted successfully";
        }

        return "Contact not found";
    }

	
}