/**
 * ClientService.java
 */
package com.omni.core.service;

import com.omni.core.model.Client;
import com.omni.core.model.User;
import java.util.List;

public interface ClientService {

    public List<Client> findAll();

    public Client findClientById(Long clientId);

    public Client findClientByRefUser(String refUser);

    public Client save(final Client client);

    public Client findClientByUser(User user);

    public Client getCurrentClient();
}
