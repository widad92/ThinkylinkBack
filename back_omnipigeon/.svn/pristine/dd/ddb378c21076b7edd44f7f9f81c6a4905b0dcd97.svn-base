package com.omni.core.repository;

import com.omni.core.model.Client;
import com.omni.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository des Clients
 *
 * @author
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findByUser(User user);
}
