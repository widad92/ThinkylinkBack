package com.omni.core.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Enchere.class)
public abstract class Enchere_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<Enchere, Long> prixMax;
	public static volatile SingularAttribute<Enchere, Long> enchereId;
	public static volatile SingularAttribute<Enchere, Date> dateDebut;
	public static volatile SingularAttribute<Enchere, Date> datefin;

	public static final String PRIX_MAX = "prixMax";
	public static final String ENCHERE_ID = "enchereId";
	public static final String DATE_DEBUT = "dateDebut";
	public static final String DATEFIN = "datefin";

}

