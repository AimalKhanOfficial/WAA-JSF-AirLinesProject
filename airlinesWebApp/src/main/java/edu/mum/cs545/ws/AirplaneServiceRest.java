package edu.mum.cs545.ws;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Named
@Path("airplane")
public class AirplaneServiceRest {

    @Inject
    AirplaneService service;

    //Aimal Khan
    //Jackson Mapper for Conversion of Java OBJs to JSON String
    ObjectMapper mapper = new ObjectMapper();

    //verified and it works
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Airplane airplane) {
        try {
            service.create(airplane);
            return mapper.writeValueAsString("Airplane Created!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
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
    @Path("/{serialNumber}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("serialNumber") String serialNumber) {
        try {
            Airplane airplane = service.findBySrlnr(serialNumber);
            service.delete(airplane);
            return mapper.writeValueAsString("Airplane deleted!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String find(Airplane airplane) {
        try {
            return mapper.writeValueAsString(service.find(airplane));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Airplane airplane) {
        try {
            service.update(airplane);
            return mapper.writeValueAsString("Airplane updated!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbyserialnumber/{serialNumber}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyserialnumber(@PathParam("serialNumber") String serialNumber) {
        try {
            Airplane airplane = service.findBySrlnr(serialNumber);
            if (airplane != null) {
                return mapper.writeValueAsString(airplane);
            } else {
                return mapper.writeValueAsString("No airplane found!");
            }
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
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

    //verified and it works
    @Path("findbymodel/{model}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbymodel(@PathParam("model") String model) {
        try {
            return mapper.writeValueAsString(service.findByModel(model));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

}
