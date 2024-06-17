package app.controller;

import app.dto.ContactDto;
import app.entity.Contact;
import app.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AuthController {

    private final ContactService contactService;

    public AuthController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        ContactDto contact = new ContactDto();
        model.addAttribute("contact", contact);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("contact") ContactDto contact,
                               BindingResult result,
                               Model model) {
        Contact existing = contactService.findByEmail(contact.getEmail());
        if (existing != null) {
            result.rejectValue("email", "email error",
                    "The email already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("contact", contact);
            return "register";
        }
        contactService.saveContact(contact);
        return "redirect:/register?success";
    }

    @GetMapping("/contacts")
    public String listRegisteredUsers(Model model) {
        List<ContactDto> contacts = contactService.findAllContacts();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
}
