package org.acme.controller;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.TrainEntity;
import org.acme.service.TrainService;




@Path("/HorarioTrem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrainController {


    private final TrainService TrainService;


    public TrainController(TrainService TrainService) {
        this.TrainService = TrainService;
    }


    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var trens = TrainService.findAll(page, pageSize);


        return Response.ok(trens).build();
    }


    @POST
    @Transactional
    public Response createTrem(TrainEntity TrainEntity) {
        return Response.ok(TrainService.createTrem(TrainEntity)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTrem(@PathParam("id") Integer ID_TREM, TrainEntity TrainEntity) {
        return Response.ok(TrainService.updateTrem(ID_TREM, TrainEntity)).build();
    }




    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer ID_TREM) {
        return Response.ok(TrainService.findById(ID_TREM)).build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Integer ID_TREM) {
        TrainService.deleteById(ID_TREM);
        return Response.noContent().build();
    }
}

