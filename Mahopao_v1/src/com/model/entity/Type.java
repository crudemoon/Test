package com.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="type", schema="jetty")
@XmlRootElement
public class Type {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	private long TypeId;
	
	private String TypeName;

	public Type(){
		
	}
	
	
	public Type(long typeId, String typeName) {
		super();
		TypeId = typeId;
		TypeName = typeName;
	}


	public long getTypeId() {
		return TypeId;
	}

	public void setTypeId(long typeId) {
		TypeId = typeId;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
}
