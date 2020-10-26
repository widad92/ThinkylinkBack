/**
 * BaseServiceImpl.java
 */
package com.omni.core.service.impl;

import com.omni.core.model.TokenUserPwa;
import com.omni.core.model.User;
import com.omni.core.repository.TokenUserPwaRepository;
import com.omni.core.service.TokenUserPwaService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tokenServicePwaService")
public class TokenUserPwaServiceImpl implements TokenUserPwaService {

    private static final Logger LOGGER = OmniCoreUtils.getLogger(TokenUserPwaServiceImpl.class);
    private static final String environnement = OmniCoreUtils.getValueFromPropertyCode("projectConfig");
    @Autowired
    private TokenUserPwaRepository tokenRepo;

    @Override
    public TokenUserPwa save(TokenUserPwa tokenUserPwa) {
        return tokenRepo.findByToken(tokenUserPwa.getToken()) == null ? tokenRepo.save(tokenUserPwa) : null;
    }

    @Override
    public boolean delete(TokenUserPwa tokenUserPwa) {
        TokenUserPwa _t = tokenRepo.findByToken(tokenUserPwa.getToken());
        tokenRepo.delete(_t);
        return true;
    }

    @Override
    public boolean notifyUser(User user, String title, String message, String urlClick) {
        LOGGER.debug("notifyUser");
        List<TokenUserPwa> tokenByUser = tokenRepo.findByUser(user);
        if (tokenByUser.size() < 1 || environnement.equalsIgnoreCase("dev")) {
            return false;
        }
        tokenByUser.forEach(token -> {
            try {
                OmniCoreUtils.sendNotificationsPWA(token.getToken(), title, message, urlClick);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                LOGGER.error(ex);
                Thread.currentThread().interrupt();
            }
        });

        return true;
    }

}
