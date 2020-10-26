package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Organisation.class)
public abstract class Organisation_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<Organisation, String> aliasOrganisation;
	public static volatile SingularAttribute<Organisation, Long> organisationId;
	public static volatile SingularAttribute<Organisation, String> responsable;
	public static volatile SingularAttribute<Organisation, Boolean> flagOrganisation;
	public static volatile SingularAttribute<Organisation, String> description;
	public static volatile SingularAttribute<Organisation, String> tel;
	public static volatile SingularAttribute<Organisation, String> siret;
	public static volatile SingularAttribute<Organisation, User> user;
	public static volatile SingularAttribute<Organisation, String> denomination;

	public static final String ALIAS_ORGANISATION = "aliasOrganisation";
	public static final String ORGANISATION_ID = "organisationId";
	public static final String RESPONSABLE = "responsable";
	public static final String FLAG_ORGANISATION = "flagOrganisation";
	public static final String DESCRIPTION = "description";
	public static final String TEL = "tel";
	public static final String SIRET = "siret";
	public static final String USER = "user";
	public static final String DENOMINATION = "denomination";

}

