package com.omni.core.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractTimestampEntity.class)
public abstract class AbstractTimestampEntity_ extends com.omni.core.model.GenericEntity_ {

	public static volatile SingularAttribute<AbstractTimestampEntity, Date> dateCreation;
	public static volatile SingularAttribute<AbstractTimestampEntity, Date> dateModification;

	public static final String DATE_CREATION = "dateCreation";
	public static final String DATE_MODIFICATION = "dateModification";

}

