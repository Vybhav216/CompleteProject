package com.ticketbooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ticketbooking.dto.SearchDTO;
import com.ticketbooking.entities.MovieShow;

import jakarta.persistence.criteria.Predicate;
@CrossOrigin
@Component
public class SearchSpecificationServiceImpl implements SearchSpecificationService{
	
	public Specification<MovieShow> getfilteredShows(SearchDTO dto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getDate() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("movieShowStartDate"), dto.getDate()),
                		criteriaBuilder.greaterThanOrEqualTo(root.get("movieShowEndDate"), dto.getDate())));
            }
            if (dto.getMovieName() != null && !dto.getMovieName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("movie").get("movieName")),
                        "%" + dto.getMovieName().toLowerCase() + "%"));
            }
            if (dto.getTheatreId()>0) {
                predicates.add(criteriaBuilder.equal(root.get("theatre"), dto.getTheatreId()));
            }
            if (dto.getSlot()>0) {
                predicates.add(criteriaBuilder.equal(root.get("slot"), dto.getSlot()));
            }
            query.orderBy(criteriaBuilder.desc(root.get("movieShowId")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
