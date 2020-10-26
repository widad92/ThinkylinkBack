/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.utils.OmniCoreUtils;
import com.omni.rest.dto.AnomalyDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * abstraction des controllers
 */
public class AbstractController {

    static final Logger LOGGER = OmniCoreUtils.getLogger(AbstractController.class);

    @Autowired
    protected Mapper mapper;

    /**
     * mappe une liste de données.
     *
     * @param <E> le type des listes en entrée.
     * @param <K> le type de liste en sortie.
     * @param datas les données en entrée
     * @param theClass
     * @return une liste de K.
     */
    protected <E, K> List<K> mapList(List<E> datas, Class<K> theClass) {
        final List<K> vals = new ArrayList<>();
        datas.stream()
                .forEach(v -> {
                    vals.add(mapper.map(v, theClass));
                });
        return vals;
    }

    /**
     * mappe une liste de données.
     *
     * @param <E> le type des listes en entrée.
     * @param <K> le type de liste en sortie.
     * @param datas les données en entrée
     * @param theClass
     * @return une liste de K.
     */
    protected <E, K> Set<K> mapSet(List<E> datas, Class<K> theClass) {
        final Set<K> vals = new HashSet<>();
        datas.stream().forEach(v -> vals.add(mapper.map(v, theClass)));
        return vals;
    }

    @ExceptionHandler(OmniException.class)
    public ResponseEntity handleException(OmniException e) {
        LOGGER.error("AbstractController - handleOmniException: " + e.toString());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new AnomalyDto(e.getMessage(), HttpStatus.FORBIDDEN));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException(Exception e) {
        LOGGER.error("AbstractController - handleException: " + e.toString());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new AnomalyDto("omniomni Anomaly", HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
