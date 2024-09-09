package co.edu.udea.vuelosback.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> login(Map<String, String> requestMap);
}
