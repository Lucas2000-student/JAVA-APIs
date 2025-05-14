package org.acme.controller;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.FaqEntity;
import org.acme.service.FaqService;




@Path("/Faq")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FaqController {


    private final FaqService FaqService;


    public FaqController(FaqService FaqService) {
        this.FaqService = FaqService;
    }


    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var faqs = FaqService.findAll(page, pageSize);


        return Response.ok(faqs).build();
    }


    @POST
    @Transactional
    public Response createFaq(FaqEntity FaqEntity) {
        return Response.ok(FaqService.createfaq(FaqEntity)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateFaq(@PathParam("id") Integer ID_FAQ, FaqEntity FaqEntity) {
        return Response.ok(FaqService.updatefaq(ID_FAQ, FaqEntity)).build();
    }




    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer ID_FAQ) {
        return Response.ok(FaqService.findById(ID_FAQ)).build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Integer ID_FAQ) {
        FaqService.deleteById(ID_FAQ);
        return Response.noContent().build();
    }
}

