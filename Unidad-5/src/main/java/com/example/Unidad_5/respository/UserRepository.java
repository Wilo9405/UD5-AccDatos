package com.example.Unidad_5.respository;

import com.example.Unidad_5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
