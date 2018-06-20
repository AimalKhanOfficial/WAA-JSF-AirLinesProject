package cs545.airline.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Flight;

@Named
@ApplicationScoped
@Transactional
public class AirlineService {

	// These services should be evaluated to reconsider which methods should be
	// public

	@Inject
	private AirlineDao airlineDao;
	
	public void create(Airline airline) {
		airlineDao.create(airline);
	}

	public void delete(Airline airline) {
		airlineDao.delete(airline);
	}

	public Airline update(Airline airline) {
		return airlineDao.update(airline);
	}

	public Airline find(Airline airline) {
		return airlineDao.findOne(airline.getId());
	}
	
	public Airline findById(long id) {
		return airlineDao.findOne(id);
	}

	public Airline findByName(String name) {
		return airlineDao.findOneByName(name);
	}

	public List<Airline> findByFlight(Flight flight) {
		return airlineDao.findByFlight(flight.getId());
	}
	
	public List<Airline> search(String searchString) {
		List<Airline> airlines = new ArrayList<Airline>(); 
		List<Airline> airs = this.findAll();
		for(Airline air : airs) {
			if(air.getName().contains(searchString)) {
				System.out.println("Searched--------------->" + air.getName());
				airlines.add(air);
			}
		}
		
		return airlines;
	}

	public List<Airline> findAll() {
		return airlineDao.findAll();
	}
}
