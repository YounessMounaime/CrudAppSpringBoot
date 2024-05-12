package com.crud.demo.ws.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.demo.ws.request.LoginRequest;
import com.crud.demo.ws.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

 
    @PostMapping("/login")
    public/* ResponseEntity<String>*/ String  login(@RequestBody @Valid LoginRequest loginRequest,  HttpSession session) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
      /*  if (userService.authenticate(email, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }*/
        if (userService.authenticate(email, password)) {
            session.setAttribute("user", email); // Connecte l'utilisateur en enregistrant son email dans la session
            return "redirect:/users"; // Redirige vers la page sécurisée
        } else {
            return "redirect:/login?error=true"; // Redirige vers la page de connexion avec un message d'erreur
        }
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalide la session, déconnectant ainsi l'utilisateur
        return "redirect:/login"; // Redirige vers la page de connexion après la déconnexion
    }


}
