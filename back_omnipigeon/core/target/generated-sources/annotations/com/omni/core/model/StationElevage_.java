package com.omni.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StationElevage.class)
public abstract class StationElevage_ extends com.omni.core.model.AbstractTimestampEntity_ {

	public static volatile SingularAttribute<StationElevage, String> responsable;
	public static volatile SingularAttribute<StationElevage, Adresse> adresse;
	public static volatile SingularAttribute<StationElevage, Long> tel;
	public static volatile ListAttribute<StationElevage, Pigeon> pigeons;
	public static volatile SingularAttribute<StationElevage, Long> stationId;

	public static final String RESPONSABLE = "responsable";
	public static final String ADRESSE = "adresse";
	public static final String TEL = "tel";
	public static final String PIGEONS = "pigeons";
	public static final String STATION_ID = "stationId";

}

