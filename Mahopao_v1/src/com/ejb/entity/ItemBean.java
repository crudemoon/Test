package com.ejb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.model.entity.Item;
import com.model.entity.Type;


/**
 * Session Bean implementation class ItemBean
 */
@Stateless
@LocalBean
public class ItemBean {

	
	@PersistenceContext(unitName="Mahopao_v1")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ItemBean() {
        // TODO Auto-generated constructor stub
    }

    
    public Item GetItem(long itemId)
    {
    	//
    	//String queryString = "SELECT c From Item c where c.itemId = :cc";
    	//Query query = em.createQuery(queryString);
    	//query.setParameter("cc", itemId);
    	//Item result =(Item) query.getResultList().get(0);
    	
    	// JPA testing
    	Item result =em.find(Item.class, itemId);
    	Type t1=new Type(333,"ºÓ±±");
    	Type t2=new Type(334,"ÎÂÖÝ");
    	List<Type> l=new ArrayList<Type>();
    	em.remove(em.find(Type.class, t1.getTypeId()));
    	em.remove(em.find(Type.class, t2.getTypeId()));
    	em.flush();
    	l.add(t1);
    	l.add(t2);
    	
    	result.setTypes(l);
    	em.persist(result);
    	em.flush();
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<Item> GetItems()
    {
    	String queryString = "SELECT c FROM Item c";
        Query query = em.createQuery(queryString);
        List<Item> result = query.getResultList();
    	return result;  
    }
    
    public boolean Save(Item i)
    {
    	em.persist(i);
    	em.flush();
    	return true;
    }
}
