package edu.mum.cs545.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import edu.mum.cs545.dto.AirlineCreationRequest;
import edu.mum.cs545.dto.FlightCreationDetail;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Named
@Path("airline")
public class AirlineServiceRest {

    @Inject
    AirlineService service;

    @Inject
    AirportService airportService;

    @Inject
    AirplaneService airplaneService;

    //Aimal Khan
    //Jackson Mapper for Conversion of Java OBJs to JSON String
    ObjectMapper mapper = new ObjectMapper();

    private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(AirlineCreationRequest airlineReq) {
        try {
            Airline airlineObj = new Airline();
            airlineObj.setName(airlineReq.getAirlineName());

            for(FlightCreationDetail airline : airlineReq.getFlightCreationDetails()){
                Airport origin = airportService.findByName(airline.getOriginName()).get(0);
                Airport destination = airportService.findByName(airline.getDestinationName()).get(0);

                Airplane airplane = airplaneService.findBySrlnr(airline.getSerialNumberAirPlane());

                Flight flight = new Flight();
                flight.setArrivalDate(airline.getArrivalDate());
                flight.setArrivalTime(airline.getArrivalTime());
                flight.setDepartureDate(airline.getDepartureDate());
                flight.setDepartureTime(airline.getDepartureTime());

                flight.setFlightnr(airline.getFlightnr());
                flight.setOrigin(origin);
                flight.setDestination(destination);

                flight.setAirplane(airplane);
                airlineObj.addFlight(flight);
            }

            service.create(airlineObj);
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
    //verified and it works
    @Path("/{name}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("name") String name) {
        try {
            service.delete(service.findByName(name));
            return mapper.writeValueAsString("Airline deleted!");
        } catch (Exception ex) {
            return "Something went wrong, try again later!";
        }
    }

    //verified and it works
    @Path("findbyname/{airlienName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findbyname(@PathParam("airlienName") String airlineName) {
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
