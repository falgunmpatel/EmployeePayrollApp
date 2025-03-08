package org.example.employeepayrollapp.controller;

import  org.example.employeepayrollapp.dto.*;
import  org.example.employeepayrollapp.interfaces.IAuthInterface;
import  org.example.employeepayrollapp.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
    ObjectMapper obj = new ObjectMapper();

    @Autowired
    EmailService emailService;

    @Autowired
    IAuthInterface iAuthInterface;

    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user) throws Exception{
        log.info("Employee tried to register with body: {}", obj.writeValueAsString(user));
        return iAuthInterface.register(user);
    }

    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user) throws Exception{
        log.info("Employee tried to login with body: {}", obj.writeValueAsString(user));
        return iAuthInterface.login(user);
    }

    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody MailDTO message){
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";
    }

    @PutMapping("/forgotPassword/{email}")
    public AuthUserDTO forgotPassword(@RequestBody PassDTO pass, @PathVariable String email){
        return iAuthInterface.forgotPassword(pass, email);
    }

    @PutMapping("/resetPassword/{email}")
    public String resetPassword(@PathVariable String email ,@RequestParam String currentPass, @RequestParam String newPass){
        return iAuthInterface.resetPassword(email, currentPass, newPass);
    }

}