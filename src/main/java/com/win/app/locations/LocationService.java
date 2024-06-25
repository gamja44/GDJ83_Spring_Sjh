package com.win.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	@Autowired
	private LocationDAO locationDAO;

	public List<LocationDTO> getlist() throws Exception {
		return locationDAO.getList();
	}

}
