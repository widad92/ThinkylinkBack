/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service;

import com.omni.core.model.Enchere;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author asus
 */
public interface EnchereService {

    public List<Enchere> findAll();

    public Enchere findEnchereById(Long enchereId);
    public Enchere save(final Enchere enchere);

    public Enchere save(final Enchere enchere);
    public void deleteById(Long enchereId);
}
