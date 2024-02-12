package com.ticketbooking.services;

import org.springframework.data.jpa.domain.Specification;

import com.ticketbooking.dto.SearchDTO;
import com.ticketbooking.entities.MovieShow;

public interface SearchSpecificationService {
	
	 Specification<MovieShow> getfilteredShows(SearchDTO dto);

}
