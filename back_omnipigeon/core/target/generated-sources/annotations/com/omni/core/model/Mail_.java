package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mail.class)
public abstract class Mail_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<Mail, String> cc;
	public static volatile SingularAttribute<Mail, String> subject;
	public static volatile SingularAttribute<Mail, String> libelle;
	public static volatile SingularAttribute<Mail, String> name;
	public static volatile SingularAttribute<Mail, String> cci;
	public static volatile SingularAttribute<Mail, Long> mailId;
	public static volatile SingularAttribute<Mail, String> emailFrom;
	public static volatile SingularAttribute<Mail, String> emailTo;
	public static volatile SingularAttribute<Mail, String> tel;
	public static volatile SingularAttribute<Mail, String> origine;
	public static volatile SingularAttribute<Mail, String> body;
	public static volatile SingularAttribute<Mail, String> type;

	public static final String CC = "cc";
	public static final String SUBJECT = "subject";
	public static final String LIBELLE = "libelle";
	public static final String NAME = "name";
	public static final String CCI = "cci";
	public static final String MAIL_ID = "mailId";
	public static final String EMAIL_FROM = "emailFrom";
	public static final String EMAIL_TO = "emailTo";
	public static final String TEL = "tel";
	public static final String ORIGINE = "origine";
	public static final String BODY = "body";
	public static final String TYPE = "type";

}

