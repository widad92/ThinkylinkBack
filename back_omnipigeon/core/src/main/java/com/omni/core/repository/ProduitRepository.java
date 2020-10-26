package com.omni.core.repository;

import com.omni.core.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository des Produit
 *
 * @author
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
