package it.govpay.pagamento.api.rs.v1.pagamenti;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import it.govpay.rs.v1.controllers.base.ProfiloController;

import it.govpay.rs.v1.BaseRsServiceV1;


@Path("/profilo")

public class Profilo extends BaseRsServiceV1{


	private ProfiloController controller = null;

	public Profilo() {
		super("profilo");
		this.controller = new ProfiloController(this.nomeServizio,this.log);
	}



/*
    @GET
    @Path("/")
    
    @Produces({ "application/json" })
    public Response profiloGET(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @QueryParam("pagina") Integer pagina, @QueryParam("risultatiPerPagina") Integer risultatiPerPagina){
        this.controller.setRequestResponse(this.request, this.response);
        return this.controller.profiloGET(this.getUser(), uriInfo, httpHeaders, pagina, risultatiPerPagina);
    }
*/

/*
    @GET
    @Path("/")
    
    @Produces({ "application/json" })
    public Response profiloGET_1(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @QueryParam("pagina") Integer pagina, @QueryParam("risultatiPerPagina") Integer risultatiPerPagina){
        this.controller.setRequestResponse(this.request, this.response);
        return this.controller.profiloGET(this.getUser(), uriInfo, httpHeaders, pagina, risultatiPerPagina);
    }
*/

/*
    @GET
    @Path("/")
    
    @Produces({ "application/json" })
    public Response profiloGET_2(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @QueryParam("pagina") Integer pagina, @QueryParam("risultatiPerPagina") Integer risultatiPerPagina){
        this.controller.setRequestResponse(this.request, this.response);
        return this.controller.profiloGET(this.getUser(), uriInfo, httpHeaders, pagina, risultatiPerPagina);
    }
*/

/*
    @GET
    @Path("/")
    
    @Produces({ "application/json" })
    public Response profiloGET_3(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders, @QueryParam("pagina") Integer pagina, @QueryParam("risultatiPerPagina") Integer risultatiPerPagina){
        this.controller.setRequestResponse(this.request, this.response);
        return this.controller.profiloGET(this.getUser(), uriInfo, httpHeaders, pagina, risultatiPerPagina);
    }
*/

}


