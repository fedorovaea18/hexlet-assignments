package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
@RestController
@RequestMapping("/contacts")
public class ContactsController {
    @Autowired
    private ContactRepository repository;

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO ContactData) {
        var contact = toEntity(contactData); 
        contactRepository.save(contact);
        var contactDTO = toDTO(contact); 
        return contactDTO;
    }

    private ContactDTO toDTO(Contact contact) {
        var dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setPhone(contact.getPhone());
        dto.setCreatedAt(contact.getCreatedAt());
        dto.setUpdatedAt(contact.getUpdatedAt());
        return contact;
    }

    private Contact toEntity(PostCreateDTO postDto) {
        var contact = new Contact();
        contact.setFirstName(contact.getFirstName());
        contact.setLastName(contact.getLastName());
        contact.setPhone(contact.getPhone());
        return dto;
    }
}
    // END

