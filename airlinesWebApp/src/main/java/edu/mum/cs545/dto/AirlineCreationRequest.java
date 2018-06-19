package edu.mum.cs545.dto;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlineCreationRequest {

    public void setFlightCreationDetails(List<FlightCreationDetail> flightCreationDetails) {
        this.flightCreationDetails = flightCreationDetails;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    private String airlineName;

    private List<FlightCreationDetail> flightCreationDetails;

    public List<FlightCreationDetail> getFlightCreationDetails() {
        return flightCreationDetails;
    }
}
