package com.by.bycake.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="type")
public class CakeType {
	private int typeid;
	private String typename;
	
	private Set<CakeType> childTypes = new HashSet<CakeType>();
	private CakeType parentType;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

	@OneToMany(mappedBy="parentType",
			targetEntity=CakeType.class,
			cascade= {CascadeType.REMOVE})
	public Set<CakeType> getChildTypes() {
		return childTypes;
	}
	public void setChildTypes(Set<CakeType> childTypes) {
		this.childTypes = childTypes;
	}
	@ManyToOne
	@JoinColumn(name="fatypeid")
	public CakeType getParentType() {
		return parentType;
	}
	public void setParentType(CakeType parentType) {
		this.parentType = parentType;
	}
	
	
}
