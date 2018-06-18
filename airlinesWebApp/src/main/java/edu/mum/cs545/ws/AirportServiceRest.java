package edu.mum.cs545.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Named
@Path("airport")
public class AirportServiceRest {

    @Inject
    AirportService service;

    //Aimal Khan
    //Jackson Mapper for Conversion of Java OBJs to JSON String
    ObjectMapper mapper = new ObjectMapper();

    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(Airport airport) {
        try {
            service.create(airport);
            return "Airport Created!";
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("getall")
    @GET
    public String getAll() {
        try {
            return mapper.writeValueAsString(service.findAll());
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
