package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produit.class)
public abstract class Produit_ extends com.omni.core.model.GenericEntity_ {

	public static volatile SingularAttribute<Produit, Long> produitId;
	public static volatile SingularAttribute<Produit, String> libelleProduit;
	public static volatile SingularAttribute<Produit, String> description;

	public static final String PRODUIT_ID = "produitId";
	public static final String LIBELLE_PRODUIT = "libelleProduit";
	public static final String DESCRIPTION = "description";

}

