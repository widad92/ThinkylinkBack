package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evenement.class)
public abstract class Evenement_ extends com.omni.core.model.GenericEntity_ {

	public static volatile SingularAttribute<Evenement, Long> evenementId;
	public static volatile SingularAttribute<Evenement, String> nom;

	public static final String EVENEMENT_ID = "evenementId";
	public static final String NOM = "nom";

}

