package com.omni.core.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> initial;
	public static volatile SingularAttribute<User, Boolean> flagUser;
	public static volatile SingularAttribute<User, String> provider;
	public static volatile SingularAttribute<User, String> tokenNumber;
	public static volatile SingularAttribute<User, Adresse> adresse;
	public static volatile SingularAttribute<User, String> refUser;
	public static volatile SingularAttribute<User, String> avatar;
	public static volatile SingularAttribute<User, Date> dateSuppression;
	public static volatile SingularAttribute<User, Long> userId;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> token;

	public static final String PASSWORD = "password";
	public static final String INITIAL = "initial";
	public static final String FLAG_USER = "flagUser";
	public static final String PROVIDER = "provider";
	public static final String TOKEN_NUMBER = "tokenNumber";
	public static final String ADRESSE = "adresse";
	public static final String REF_USER = "refUser";
	public static final String AVATAR = "avatar";
	public static final String DATE_SUPPRESSION = "dateSuppression";
	public static final String USER_ID = "userId";
	public static final String EMAIL = "email";
	public static final String TOKEN = "token";

}

