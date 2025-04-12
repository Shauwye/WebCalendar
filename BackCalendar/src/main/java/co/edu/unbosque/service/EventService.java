package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.dto.EventDTO;
import co.edu.unbosque.model.Event;
import co.edu.unbosque.repository.EventRepository;

public class EventService {
	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public EventService() {
		// TODO Auto-generated constructor stub
	}
	public int create(EventDTO data){
		Event entity = modelMapper.map(data, Event.class);
		try {
			eventRepo.save(entity);
			return 0;
		} catch (Exception e) {
			return 1;
			// TODO: handle exception
		}
	}
	public ArrayList<EventDTO> findAll(){
		ArrayList<Event> entityList = (ArrayList<Event>) eventRepo.findAll();
		ArrayList<EventDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity)->{
			EventDTO dto = modelMapper.map(entity, EventDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}
	public ArrayList<EventDTO> findID(Integer id){
		Optional<Event> entityList = eventRepo.findById(id);
		ArrayList<EventDTO> dtoList = new ArrayList<>();
		entityList.ifPresent(entity -> {
		        EventDTO dto = modelMapper.map(entity, EventDTO.class);
		        dtoList.add(dto);
		});
		return dtoList;
	}
	public int deleteById(Integer id) {
		Optional<Event> found = eventRepo.findById(id);
		if(found.isPresent()) {
			eventRepo.delete(found.get());
			return 0;
		}else {
			return 1;
		}
	}
	public int update(Integer id, EventDTO data) {
	    Optional<Event> optionalEvent = eventRepo.findById(id);
	    
	    if (optionalEvent.isPresent()) {
	        Event existingEvent = optionalEvent.get();
	        
	        // Actualizar solo los campos necesarios
	        existingEvent.setName(data.getName());
	        existingEvent.setDay(data.getDay());
	        existingEvent.setRepeat(data.getRepeat());
	        existingEvent.setDescription(data.getDescription());
	       
	   

	        try {
	            eventRepo.save(existingEvent);
	            return 0; // Éxito
	        } catch (Exception e) {
	            return 1; // Error en la actualización
	        }
	    } else {
	        return 2; // No se encontró el pasajero con ese ID
	    }
	}
	
	public int contar() {
		return (int) eventRepo.count();
	}
}
