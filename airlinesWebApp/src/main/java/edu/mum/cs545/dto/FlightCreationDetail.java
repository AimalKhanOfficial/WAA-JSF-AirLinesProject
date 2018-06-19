package edu.mum.cs545.dto;

public class FlightCreationDetail {

    private String flightnr;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;

    private String originName;
    private String destinationName;
    private String serialNumberAirPlane;



    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getSerialNumberAirPlane() {
        return serialNumberAirPlane;
    }

    public void setSerialNumberAirPlane(String serialNumberAirPlane) {
        this.serialNumberAirPlane = serialNumberAirPlane;
    }
    public String getFlightnr() {
        return flightnr;
    }

    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
