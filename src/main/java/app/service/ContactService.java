package app.service;

import app.dto.ContactDto;
import app.entity.Contact;

import java.util.List;

public interface ContactService {


    void saveContact(ContactDto contactDto);

    Contact findByEmail(String email);

    List<ContactDto> findAllContacts();
}
