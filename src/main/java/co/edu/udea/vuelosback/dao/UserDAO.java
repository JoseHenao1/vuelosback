package co.edu.udea.vuelosback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.udea.vuelosback.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{

    User findByEmail(@Param(("email")) String email);
}
