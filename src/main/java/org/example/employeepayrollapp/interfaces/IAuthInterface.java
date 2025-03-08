package org.example.employeepayrollapp.interfaces;

import  org.example.employeepayrollapp.dto.AuthUserDTO;
import  org.example.employeepayrollapp.dto.LoginDTO;
import  org.example.employeepayrollapp.dto.PassDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAuthInterface {

    public String register(AuthUserDTO user);


    public String login(LoginDTO user);

    public AuthUserDTO forgotPassword(PassDTO pass, String email);

    public String resetPassword(String email, String currentPass, String newPass);
}