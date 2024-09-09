package co.edu.udea.vuelosback.security;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.udea.vuelosback.dao.UserDAO;
import co.edu.udea.vuelosback.models.User;

@Service
public class UserDetailsServ implements UserDetailsService {    

    @Autowired
    private UserDAO userDAO;


    private User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail = userDAO.findByEmail(username);

        if (!Objects.isNull(userDetail)) {
            return new org.springframework.security.core.userdetails.User(userDetail.getMail(), userDetail.getPassword(), new ArrayList<>() );
        }else {
            throw new UsernameNotFoundException("No existe el usuario");
        }
    }

    public User getUserDetail() {
        return userDetail;
    }

}
