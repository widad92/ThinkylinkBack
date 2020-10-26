/**
 * UserService.java
 */
package com.omni.core.service;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.User;
import java.util.List;

/**
 * This class is {@link UserService} user service interface.
 *
 *
 * @author
 *
 */
public interface UserService {

    public boolean authenticateUser(User user, String provider) throws OmniException;

    public List<User> getAllUsers();

    public User getUserByEmail(String email);

    public void forgotPassword(String email);

    public void sendNewCodeValidation(String email);

    public boolean modifyPassword(User user);

    /**
     * enregistre un user en base. Elle met le user à jour s'il existe déja en
     * base, sinon il est crée.
     *
     * @param user le user à enregistrée
     * @return le user enregistré
     */
    User save(final User user);

    /**
     * supprime un user de la base.
     *
     * @param user l'entité à supprimer
     */
    void delete(final User user);

    /**
     * Revoie le Hash au format BCrypt d'un mot de passe
     *
     * @param plainTextPassword
     * @return Hashed password
     */
    public String getHashUserPassword(String plainTextPassword);

    /**
     * Vérifie si un login existe dans la base
     *
     * @param email
     * @return true si login existe, sinon false
     */
    public boolean verifyEmailExiste(String email);

    /**
     * Valide le nouveau mot de passe d'un user après le mail, après
     * vérification du token
     *
     * @param user
     */
    public void validateUser(User user);

    public User getUserByTokenAndEmail(String token, String email) throws OmniException;

    /**
     * Get current user logged
     *
     * @return current user
     */
    public User getCurrentUser();
}
