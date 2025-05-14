package org.acme.controller;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.LocaisEntity;
import org.acme.service.LocaisService;




@Path("/Locais")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocaisController {


    private final LocaisService LocaisService;


    public LocaisController(LocaisService LocaisService) {
        this.LocaisService = LocaisService;
    }


    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var estacoes = LocaisService.findAll(page, pageSize);


        return Response.ok(estacoes).build();
    }


    @POST
    @Transactional
    public Response createFaq(LocaisEntity LocaisEntity) {
        return Response.ok(LocaisService.createLocal(LocaisEntity)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateFaq(@PathParam("id") Integer ID_LOCAL, LocaisEntity LocaisEntity) {
        return Response.ok(LocaisService.updateLocal(ID_LOCAL, LocaisEntity)).build();
    }




    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer ID_LOCAL) {
        return Response.ok(LocaisService.findById(ID_LOCAL)).build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Integer ID_LOCAL) {
        LocaisService.deleteById(ID_LOCAL);
        return Response.noContent().build();
    }
}

