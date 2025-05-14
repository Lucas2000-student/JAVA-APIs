package org.acme.controller;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.EstacaoEntity;
import org.acme.service.EstacaoService;




@Path("/Estacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacaoController {


    private final EstacaoService EstacaoService;


    public EstacaoController(EstacaoService EstacaoService) {
        this.EstacaoService = EstacaoService;
    }


    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var estacoes = EstacaoService.findAll(page, pageSize);


        return Response.ok(estacoes).build();
    }


    @POST
    @Transactional
    public Response createFaq(EstacaoEntity EstacaoEntity) {
        return Response.ok(EstacaoService.createEstacao(EstacaoEntity)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateFaq(@PathParam("id") Integer ID_ESTACAO, EstacaoEntity EstacaoEntity) {
        return Response.ok(EstacaoService.updateestacao(ID_ESTACAO, EstacaoEntity)).build();
    }




    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer ID_ESTACAO) {
        return Response.ok(EstacaoService.findById(ID_ESTACAO)).build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Integer ID_ESTACAO) {
        EstacaoService.deleteById(ID_ESTACAO);
        return Response.noContent().build();
    }
}
