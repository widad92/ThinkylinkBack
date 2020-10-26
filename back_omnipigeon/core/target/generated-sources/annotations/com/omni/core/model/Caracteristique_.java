package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Caracteristique.class)
public abstract class Caracteristique_ extends com.omni.core.model.GenericEntity_ {

	public static volatile SingularAttribute<Caracteristique, String> libelleCaracteristique;
	public static volatile SingularAttribute<Caracteristique, String> caracteristiqueAile;
	public static volatile SingularAttribute<Caracteristique, String> codeCaracteristique;
	public static volatile SingularAttribute<Caracteristique, String> caracteristiqueGenerales;
	public static volatile SingularAttribute<Caracteristique, Long> caracteristiqueId;

	public static final String LIBELLE_CARACTERISTIQUE = "libelleCaracteristique";
	public static final String CARACTERISTIQUE_AILE = "caracteristiqueAile";
	public static final String CODE_CARACTERISTIQUE = "codeCaracteristique";
	public static final String CARACTERISTIQUE_GENERALES = "caracteristiqueGenerales";
	public static final String CARACTERISTIQUE_ID = "caracteristiqueId";

}

