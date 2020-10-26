package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<Client, Long> clientId;
	public static volatile SingularAttribute<Client, String> tel;
	public static volatile ListAttribute<Client, Pigeon> pigeons;
	public static volatile SingularAttribute<Client, User> user;
	public static volatile SingularAttribute<Client, String> nom;
	public static volatile SingularAttribute<Client, String> prenom;
	public static volatile SingularAttribute<Client, Evenement> evenement;
	public static volatile SingularAttribute<Client, String> civilite;

	public static final String CLIENT_ID = "clientId";
	public static final String TEL = "tel";
	public static final String PIGEONS = "pigeons";
	public static final String USER = "user";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String EVENEMENT = "evenement";
	public static final String CIVILITE = "civilite";

}

