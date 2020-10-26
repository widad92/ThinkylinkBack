package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TokenUserPwa.class)
public abstract class TokenUserPwa_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<TokenUserPwa, Long> tokenId;
	public static volatile SingularAttribute<TokenUserPwa, User> user;
	public static volatile SingularAttribute<TokenUserPwa, String> token;

	public static final String TOKEN_ID = "tokenId";
	public static final String USER = "user";
	public static final String TOKEN = "token";

}

