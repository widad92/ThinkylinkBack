package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Adresse.class)
public abstract class Adresse_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<Adresse, String> libelleAdresse;
	public static volatile SingularAttribute<Adresse, String> ville;
	public static volatile SingularAttribute<Adresse, Long> adresseId;
	public static volatile SingularAttribute<Adresse, String> latitude;
	public static volatile SingularAttribute<Adresse, String> adr3;
	public static volatile SingularAttribute<Adresse, String> cp;
	public static volatile SingularAttribute<Adresse, String> adr2;
	public static volatile SingularAttribute<Adresse, String> adr1;
	public static volatile SingularAttribute<Adresse, String> pays;
	public static volatile SingularAttribute<Adresse, String> longitude;

	public static final String LIBELLE_ADRESSE = "libelleAdresse";
	public static final String VILLE = "ville";
	public static final String ADRESSE_ID = "adresseId";
	public static final String LATITUDE = "latitude";
	public static final String ADR3 = "adr3";
	public static final String CP = "cp";
	public static final String ADR2 = "adr2";
	public static final String ADR1 = "adr1";
	public static final String PAYS = "pays";
	public static final String LONGITUDE = "longitude";

}

