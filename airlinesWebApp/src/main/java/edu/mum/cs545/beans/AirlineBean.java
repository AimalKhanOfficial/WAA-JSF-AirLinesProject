package edu.mum.cs545.beans;
/**
*
* @author Prakash Rai 
* Created On: June 18, 2018 
* Description: Bean for Airline
*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named("airlineBean")
@SessionScoped
public class AirlineBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AirlineService airlineService;
	private Airline airline = new Airline();
	private List<Airline>airlines=new ArrayList<>();

	/*
	 * Method to edit airline
	 * Input parameter : Airline object
	 * Output : view name
	*/
	public String edit(Airline airline) {
		this.airlineService.update(airline);
		return "airlines";
	}
	
	/*
	 * Method to delete airline
	 * Input parameter : Airline object
	 * Output : view name
	*/
	public String delete(long id) {
		Airline airline = this.airlineService.findById(id);
		this.airlineService.delete(airline);
		return "airlines";
	}
	
	/*
	 * Method to create airline
	 * Input parameter : Airline object
	 * Output : view name
	*/
	public String create() {
		this.airlineService.create(airline);
		this.airline = new Airline();
		return "airlines";
	}
	
	/*
	 * airline getter
	*/
	public Airline getAirline() {
		return airline;
	}

	/*
	 * airline setter
	*/
	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	/*
	 * airline list getter
	*/
	public List<Airline> getAirlines() {
		airlines=airlineService.findAll();
		return airlines;
	}

	/*
	 * airline list setter
	*/
	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

}
