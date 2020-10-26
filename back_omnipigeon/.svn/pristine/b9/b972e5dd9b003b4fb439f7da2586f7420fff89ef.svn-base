package com.omni.core.repository;

import com.omni.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public User findByToken(String token);
    
    public User findByRefUser(String refUser);

    public User findByTokenAndEmail(String token, String email);
    
    public User findByTokenNumberAndEmail(String token, String email);

}
