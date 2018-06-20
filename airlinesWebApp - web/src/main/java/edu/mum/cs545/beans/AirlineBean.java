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

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static final long serialVersionUID = 1L;

	/********************Injecting airline service***************************************************************/
	@Inject
	private AirlineService airlineService;
	
	/********************Airline object: used to refer airline while saving and editing**************************/
	private Airline airline = new Airline();
	
	/********************Airline list: used for listing airlines*************************************************/
	private List<Airline>airlines=new ArrayList<>();
	
	/************************************Search String*****************************************/
	private String searchText;

	/*
	 * Search text getter
	*/
	public String getSearchText() {
		return searchText;
	}

	/*
	 * Search text setter
	*/
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	/*
	 * Method to search airline
	 * Output : searched airlines
	*/
	public void searchAirline() {
		System.out.println("--------------------------------Search Text--------------> " + searchText);
		this.searchText = "Here in search ..";
//		if(searchText != null || searchText != "")
//		{
//			this.airlines = this.airlineService.search(searchText);
//			System.out.println("airlines-----------------" + airlines.size());
//		}
	}
	
	/*
	 * Method to edit airline
	 * Input parameter : Airline object
	 * Output : view name
	*/
	public String edit(Airline airline) {
		this.airlineService.update(airline);
		this.airline = new Airline();
		return "airlines";
	}
	
	/*
	 * Details method page
	 * Input parameter : Airline object
	 * Output : view name
	*/
	public String details(Airline air) {
		this.airline = air;
		return "airlineDetails";
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
		airline = new Airline();
		return airlines;
	}

	/*
	 * airline list setter
	*/
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
