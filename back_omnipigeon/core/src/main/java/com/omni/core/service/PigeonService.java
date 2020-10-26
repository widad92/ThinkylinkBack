/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service;
import com.omni.core.model.Pigeon;
import java.util.List;

/**
 *
 * @author asus
 */
public interface PigeonService {
    public List<Pigeon> findAll();

    public Pigeon findPigeonById(Long pigeonId);

   // public List<Pigeon> findPigeonByRefClient(String refClient);

    public Pigeon save(final Pigeon pigeon);

}
