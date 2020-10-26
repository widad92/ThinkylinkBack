package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Acteur.class)
public abstract class Acteur_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<Acteur, String> profession;
	public static volatile SingularAttribute<Acteur, Long> acteurId;
	public static volatile ListAttribute<Acteur, Pigeon> pigeons;
	public static volatile SingularAttribute<Acteur, String> nom;
	public static volatile SingularAttribute<Acteur, String> prenom;

	public static final String PROFESSION = "profession";
	public static final String ACTEUR_ID = "acteurId";
	public static final String PIGEONS = "pigeons";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";

}

