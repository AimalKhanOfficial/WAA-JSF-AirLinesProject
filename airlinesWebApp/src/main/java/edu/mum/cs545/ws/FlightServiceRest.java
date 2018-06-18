package edu.mum.cs545.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Named
@Path("flight")
public class FlightServiceRest {
    @Inject
    FlightService service;

    //Aimal Khan
    //Jackson Mapper for Conversion of Java OBJs to JSON String
    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        try {
            return mapper.writeValueAsString(service.findAll());
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Flight flight) {
        try {
            service.create(flight);
            return mapper.writeValueAsString("Flight Created!");
        } catch (Exception ex) {
            String date = df.format(new Date());
            System.out.println(date);
            return "Something went wrong, try again later!" + date;
        }
    }

    @Path("find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String find(Flight flight) {
        try {
            return mapper.writeValueAsString(service.find(flight));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Flight flight) {
        try {
            service.update(flight);
            return mapper.writeValueAsString("Airport updated!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbynumber/{flightNumber}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbynumber(@PathParam("flightNumber") String flightNumber) {
        try {
            return mapper.writeValueAsString(service.findByNumber(flightNumber));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbyairline")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyairline(Airline airline) {
        try {
            return mapper.writeValueAsString(service.findByAirline(airline));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbyorigin")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyorigin(Airport airport) {
        try {
            return mapper.writeValueAsString(service.findByOrigin(airport));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbydestination")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbydestination(Airport airport) {
        try {
            return mapper.writeValueAsString(service.findByDestination(airport));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbyairplane")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyairplane(Airplane airplane) {
        try {
            return mapper.writeValueAsString(service.findByAirplane(airplane));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbyarrival/{date}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyarrival(@PathParam("date") Date date) {
        try {
            return mapper.writeValueAsString(service.findByArrival(date));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbydeparture/{date}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbydeparture(@PathParam("date") Date date) {
        try {
            return mapper.writeValueAsString(service.findByDeparture(date));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbyarrivalbetween")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyarrivalbetween(@QueryParam("datetimeFrom") Date datetimeFrom, @QueryParam("datetimeTo") Date datetimeTo) {
        try {
            return mapper.writeValueAsString(service.findByArrivalBetween(datetimeFrom, datetimeTo));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    @Path("findbydeparturebetween")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findbydeparturebetween(@QueryParam("datetimeFrom") Date datetimeFrom, @QueryParam("datetimeTo") Date datetimeTo) {
        try {
            return mapper.writeValueAsString(service.findByDepartureBetween(datetimeFrom, datetimeTo));
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }
}
