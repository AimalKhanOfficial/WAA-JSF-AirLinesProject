package edu.mum.cs545.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;


	
	@Named("flightBean")
	@SessionScoped
	public class FlightBean implements Serializable {

		private static final long serialVersionUID = 1L;

		@Inject
		private FlightService flightService;
		
		
		public List<Flight> getAllFlights() {
			
			List<Flight> flights;
			flights = flightService.findAll();
			return flights;
		}
		
		private Flight flight=new Flight();
		private List<Flight> flights=new ArrayList<>();

		public FlightService getAirlineService() {
			return flightService;
		}

		public void setFlightService(FlightService flightService) {
			this.flightService = flightService;
		}

		public Flight getFlight() {
			return flight;
		}

		public void setFlight(Flight flight) {
			this.flight = flight;
		}

		public List<Flight> getFlights() {
			flights=flightService.findAll();
			return flights;
		}

		public void setFlights(List<Flight> airlines) {
			this.flights = flights;
		}
	}


