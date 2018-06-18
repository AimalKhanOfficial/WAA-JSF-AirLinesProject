package edu.mum.cs545.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirportService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Named
@Path("airport")
public class AirportServiceRest {

    @Inject
    AirportService service;

    //Aimal Khan
    //Jackson Mapper for Conversion of Java OBJs to JSON String
    ObjectMapper mapper = new ObjectMapper();

    //verified and it works
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Airport airport) {
        try {
            service.create(airport);
            return mapper.writeValueAsString("Airport Created!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("/{name}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("name") String name) {
        try {
            service.delete(service.findByName(name).get(0));
            return mapper.writeValueAsString("Airport deleted!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works - we can just pass a single value of a class lets say id!
    // Example:
    // {
    //  "id": 351
    // }
    @Path("find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String find(Airport airport) {
        try {
            return mapper.writeValueAsString(service.find(airport));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Airport airport) {
        try {
            service.update(airport);
            return mapper.writeValueAsString("Airport updated!");
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
    @Path("findbycode/{airportCode}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbycode(@PathParam("airportCode") String airportCode) {
        try {
            return mapper.writeValueAsString(service.findByCode(airportCode));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }


    @Path("findbyarrival")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyarrival(Flight flight) {
        try {
            return mapper.writeValueAsString(service.findByArrival(flight));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbydeparture")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbydeparture(Flight flight) {
        try {
            return mapper.writeValueAsString(service.findByDeparture(flight));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }


    //verified and it works with Get, but what if there is a space in city name?
    //Need to make it post
    //verified and it works
    @Path("findbycity")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbycity(String cityName) {
        try {
            return mapper.writeValueAsString(service.findByCity(cityName));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("findbycountry")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbycountry(String countryName) {
        try {
            return mapper.writeValueAsString(service.findByCountry(countryName));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("findbyname")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyname(String airportName) {
        try {
            return mapper.writeValueAsString(service.findByName(airportName));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }
}
