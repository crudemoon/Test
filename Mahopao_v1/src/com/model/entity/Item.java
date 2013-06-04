package com.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;




@Entity
@Table(name="Item", schema="jetty")
@XmlRootElement
public class Item{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long itemId;
	
	private String ItemName;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="typeId")
	private List<Type> types;
	


	public Item()
	{
		
	}
	
	public Item(long itemId, String itemName) {
		super();
		this.itemId = itemId;
		ItemName = itemName;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	
	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", ItemName=" + ItemName + "]";
	}	
	
}
