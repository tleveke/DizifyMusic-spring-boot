package com.ynov.nantes.soap.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.soap.config.JwtTokenUtil;
import com.ynov.nantes.soap.entity.User;
import com.ynov.nantes.soap.model.JwtRequest;
import com.ynov.nantes.soap.model.JwtResponse;
import com.ynov.nantes.soap.repository.UserRepository;

import com.google.gson.Gson;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    
    private UserRepository userRepository;

    public JwtAuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

  @Autowired
  private AuthenticationManager authenticationManager;
  
  private static final Gson gson = new Gson();

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserDetailsService jwtInMemoryUserDetailsService;

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
      throws Exception {
      System.out.println("Yo");
      ResponseEntity<?> response = ResponseEntity.ok(gson.toJson("Not found"));
      Boolean userExist = userRepository.existsByEmail(authenticationRequest.getUsername());
      System.out.println(userExist);
      
      if (userExist) {
          User user = userRepository.findUserByEmail(authenticationRequest.getUsername());
          System.out.println(user);
          if (user.getPassword().equals(authenticationRequest.getPassword())) {
              System.out.println("Yop");
              //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
              System.out.println("Lo");

              final UserDetails userDetails = jwtInMemoryUserDetailsService
                  .loadUserByUsername(authenticationRequest.getUsername());
              

              System.out.println("cr");

              final String token = jwtTokenUtil.generateToken(userDetails);
              System.out.println("Yaaaaaaaaao");
              
              response = ResponseEntity.ok(new JwtResponse(token));
          }
      }  

    return response;
  }

  private void authenticate(String username, String password) throws Exception {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
