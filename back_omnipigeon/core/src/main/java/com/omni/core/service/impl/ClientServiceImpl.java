/**
 * ClientServiceImpl.java
 */
package com.omni.core.service.impl;

import com.omni.core.model.Client;
import com.omni.core.model.User;
import com.omni.core.repository.ClientRepository;
import com.omni.core.repository.UserRepository;
import com.omni.core.service.ClientService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Client findClientById(Long clientId) {
        return clientRepo.findOne(clientId);
    }

    @Override
    public Client save(Client clientToSave) {
        Client client = clientToSave;
        if (client.getClientId() != null) {
            final Client clientFromDB = clientRepo.findOne(client.getClientId());
            OmniCoreUtils.copyNonNullProperties(clientToSave, clientFromDB);
            client = clientFromDB;
            return clientRepo.save(client);
        }
        return clientRepo.save(client);
    }

    @Override
    public Client findClientByUser(User user) {
        return clientRepo.findByUser(user);
    }

    @Override
    public Client getCurrentClient() {
        final User user = userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        final Client client = findClientByUser(user);
        return client;
    }

    @Override
    public Client findClientByRefUser(String refUser) {
        return findClientByUser(userRepo.findByRefUser(refUser));
    }

}
