package co.edu.udea.vuelosback.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import co.edu.udea.vuelosback.security.UserDetailsServ;
import co.edu.udea.vuelosback.security.jwt.JwtUtil;
import co.edu.udea.vuelosback.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServ userDetailServ;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try {
          Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password"))
          );


          if (authentication.isAuthenticated()) {
            if (userDetailServ.getUserDetail() != null ) {
              return new ResponseEntity<String>("{\"token\":\"" + jwtUtil.generateToken(userDetailServ.getUserDetail().getMail(), userDetailServ.getUserDetail().getRolesAplicacion().getRol()) +  "\"}", HttpStatus.OK);
            }
          }
            
        } catch (Exception e) {
          System.out.println("Ha ocurrido un error al intentar loguearse " + e.getMessage());
        }
        return new ResponseEntity<String>("{\"mensaje\":\"" + "Credenciales Incorrectas" +  "\"}", HttpStatus.BAD_REQUEST);
    }
}
