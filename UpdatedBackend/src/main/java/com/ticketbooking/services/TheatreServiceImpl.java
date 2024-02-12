package com.ticketbooking.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dto.SeatDTO;
import com.ticketbooking.entities.Seat;
import com.ticketbooking.entities.Theatre;
import com.ticketbooking.repository.TheatreRepository;
import com.ticketbooking.repository.SeatRepository;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TheatreServiceImpl(
            TheatreRepository theatreRepository,
            SeatRepository seatRepository,
            ModelMapper modelMapper) {
        this.theatreRepository = theatreRepository;
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public void saveSeat(SeatDTO seatDTO) {
//        // Implementation using the injected dependencies.
//        Seat seat = modelMapper.map(seatDTO, Seat.class);
//        seatRepository.save(seat);
//    }
    
    
    
    
    @Override
    public void saveCapacity(SeatDTO seatDTO) {
    	Seat hc=new Seat();
		BeanUtils.copyProperties(seatDTO, hc);
		Theatre theatre=theatreRepository.getById(seatDTO.getTheatreId());
		hc.setTheatre(theatre);
		
		Seat hcc= seatRepository.save(hc);
		List<Seat> hcs= theatre.getSeats();
		hcs.add(hcc);
		theatre.setSeats(hcs);
		theatreRepository.save(theatre);
	}
    
    
    
    

//    @Override
//    public void deleteSeat(int id) {
//        // Implementation using the injected dependencies.
//        seatRepository.deleteById(id);
//    }
    
    
    @Override
    public void deleteSeat(int id) {
    	Seat hc=seatRepository.getById(id);
    	Theatre theatre=hc.getTheatre();
		List<Seat> hcs= theatre.getSeats();
		hcs.remove(hc);
		theatreRepository.save(theatre);
		seatRepository.delete(hc);
	}
    
    
    
    
    

    @Override
    public void saveTheatre(Theatre theatre) {
        // Implementation using the injected dependencies.
        theatreRepository.save(theatre);
    }

    @Override
    public List<Theatre> listAllTheatres() {
//        List<Theatre> theatres = theatreRepository.findAll();
//        return theatres.stream()
//                .map(theatre -> modelMapper.map(theatre, TheatreDTO.class))
//                .collect(Collectors.toList());
    	 return theatreRepository.findAll();
    	
    }

    @Override
    public Theatre findTheatreById(int id) {
        //Theatre theatre = theatreRepository.getById(id);
        //return modelMapper.map(theatre, TheatreDTO.class);
        return theatreRepository.getById(id);
    }

    @Override
    public void deleteTheatre(int id) {
        theatreRepository.deleteById(id);
    }
//    @Override
//    public void updateTheatre(TheatreDTO theatreDTO) {
//        Theatre existingTheatre = theatreRepository.findById(theatreDTO.getTheatreId())
//                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + theatreDTO.getTheatreId()));
//
//        // Update the existing theatre with new values from the DTO
//        modelMapper.map(theatreDTO, existingTheatre);
//
//        // Save the updated theatre
//        theatreRepository.save(existingTheatre);
//    }

	@Override
	public Theatre findById(int theatreId) {
		// TODO Auto-generated method stub
		return theatreRepository.getById(theatreId);
	}

//	@Override
//	public boolean isTheatreCityExists(String theatreCity) {
//		// TODO Auto-generated method stub
//		return theatreRepository.existsByTheatreCity(theatreCity);
//	}
//
//	@Override
//	public boolean isTheatreNameExists(String theatreName) {
//		// TODO Auto-generated method stub
//		return theatreRepository.existsByTheatreName(theatreName);
//	}

}
