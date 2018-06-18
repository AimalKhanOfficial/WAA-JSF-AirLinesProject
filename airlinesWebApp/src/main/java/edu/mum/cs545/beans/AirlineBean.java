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
	private Airline airline=new Airline("Emirates");
	private List<Airline>airlines=new ArrayList<>();
	private long airlineId;

	public String edit(long id) {
		System.out.println("<------------------Edit Airline------------------->");
//		this.airline.setId(id);
//		Airline obj = this.airlineService.find(this.airline);
//		obj.setName(this.airline.getName());
//		System.out.println("Id : " + obj.getId() + ", Airline : " + obj.getName());
//		this.airlineService.update(obj);
		return "airlines";
	}
	
	public String create() {
		System.out.println("<------------------Create Airline------------------->");
		this.airlineService.create(airline);
		return "airlines";
	}
	
	public AirlineService getAirlineService() {
		return airlineService;
	}

	public void setAirlineService(AirlineService airlineService) {
		this.airlineService = airlineService;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public List<Airline> getAirlines() {
		airlines=airlineService.findAll();
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}
}
