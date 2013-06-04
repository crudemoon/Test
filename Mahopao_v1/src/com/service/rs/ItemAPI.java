package com.service.rs;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.ejb.entity.ItemBean;
import com.model.entity.Item;


@Stateless
@Path("item/{id}")
public class ItemAPI {
    @EJB
    private ItemBean iBean;
	
    @Context
    private UriInfo context;


    /**
     * Default constructor. 
     */
    public ItemAPI() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of VendorInfo
     * @return an instance of String
     */
    @GET
    @Produces({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
    public Item getXml(@PathParam(value = "id") long itemId) {
        // TODO return proper representation object
        return iBean.GetItem(itemId);
    }

    /**
     * PUT method for updating or creating an instance of VendorInfo
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    @Path("{name}")
    public void putXml(@PathParam(value="id") long itemId,@PathParam (value="name") String ItemName) {
    	iBean.Save( new Item(itemId, ItemName));
    }

}