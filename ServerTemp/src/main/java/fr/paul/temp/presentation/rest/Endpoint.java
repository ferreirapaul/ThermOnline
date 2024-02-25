package fr.paul.temp.presentation.rest;

import fr.paul.temp.converter.TempConverter;
import fr.paul.temp.domain.entity.TempEntity;
import fr.paul.temp.domain.service.TempService;
import fr.paul.temp.presentation.rest.response.GetAllResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.EOFException;
import java.util.List;

@Path("/")
@Transactional
public class Endpoint {
    private TempService tempService;

    @Path("test")
    @GET
    public Response test()
    {
        System.out.println("Test succeeded !");
        return Response.accepted().build();
    }

    @Path("sendTemps/{t}/{h}")
    @GET
    public Response sendTemp(@PathParam("t") String temp, @PathParam("h") String hum)
    {
        init();
        this.tempService.AddTemp(temp, hum);
        return Response.ok().build();
    }

    @Path("getTemp")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getTemp()
    {
        init();
        List<TempEntity> s = this.tempService.getAllTemps();
        List<GetAllResponse> res = TempConverter.tempModelToResp(s);
        return Response.ok(res).build();
    }

    public void init()
    {
        if (this.tempService == null)
        {
            this.tempService = new TempService();
        }
    }
}
