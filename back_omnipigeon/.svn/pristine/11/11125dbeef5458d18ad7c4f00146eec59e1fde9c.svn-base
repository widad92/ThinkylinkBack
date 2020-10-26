package com.omni.core.repository;

import com.omni.core.model.TokenUserPwa;
import com.omni.core.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository
 *
 * @author
 */
@Repository
public interface TokenUserPwaRepository extends JpaRepository<TokenUserPwa, Long> {

    List<TokenUserPwa> findByUser(User user);

    TokenUserPwa findByToken(String token);

}
