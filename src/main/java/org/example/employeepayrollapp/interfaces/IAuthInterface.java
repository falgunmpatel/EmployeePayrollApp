package org.example.employeepayrollapp.interfaces;

import org.example.employeepayrollapp.dto.AuthUserDTO;
import org.example.employeepayrollapp.dto.LoginDTO;
import org.example.employeepayrollapp.dto.PassDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAuthInterface {

  String register(AuthUserDTO user);

  String login(LoginDTO user);

  AuthUserDTO forgotPassword(PassDTO pass, String email);

  String resetPassword(String email, String currentPass, String newPass);

  String clear();
}