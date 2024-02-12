package com.ticketbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.entities.Theatre;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer>, JpaSpecificationExecutor<MovieShow> {

    @Query(value = "SELECT * FROM movie_show WHERE startDate <= ?1 AND endDate >= ?1", nativeQuery = true)
    List<MovieShow> findByDate(String date);

    @Query("SELECT m FROM MovieShow m WHERE m.movieShowStartDate <= :currentDate AND m.movieShowEndDate >= :currentDate")
    List<MovieShow> todaysShow(LocalDate currentDate);
    
    List<MovieShow> findByMovieShowStartDateBetween(LocalDate startDate, LocalDate endDate);

    List<MovieShow> findAll(Specification<MovieShow> spec);
    
    boolean existsByTheatre(Theatre theatre);
    
    boolean existsBySlot(int slot);
}
