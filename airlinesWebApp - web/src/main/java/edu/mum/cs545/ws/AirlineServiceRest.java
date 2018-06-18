package edu.mum.cs545.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Named
@Path("airline")
public class AirlineServiceRest {

    @Inject
    AirlineService service;

    //Aimal Khan
    //Jackson Mapper for Conversion of Java OBJs to JSON String
    ObjectMapper mapper = new ObjectMapper();

    //verified and it works
    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        try {
            return mapper.writeValueAsString(service.findAll());
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    //verified and it works
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Airline airline) {
        try {
            service.create(airline);
            return mapper.writeValueAsString("Airline Created!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String find(Airline airline) {
        try {
            return mapper.writeValueAsString(service.find(airline));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Airline airline) {
        try {
            service.update(airline);
            return mapper.writeValueAsString("Airport updated!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(Airline airline) {
        try {
            service.delete(airline);
            return mapper.writeValueAsString("Airline deleted!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("findbyname")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyname(String airlineName) {
        try {
            return mapper.writeValueAsString(service.findByName(airlineName));
        } catch (Exception ex) {
            return "Something went wrong, try again later!"  + ex.getMessage();
        }
    }

    @Path("findbyflight")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyflight(Flight flight) {
        try {
            return mapper.writeValueAsString(service.findByFlight(flight));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }
}
