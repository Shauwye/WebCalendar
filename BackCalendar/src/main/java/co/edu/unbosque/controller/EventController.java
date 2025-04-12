package co.edu.unbosque.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.dto.EventDTO;
import co.edu.unbosque.service.EventService;

@RestController
@RequestMapping ("/event")
@CrossOrigin (origins = {"*"})
public class EventController {
	@Autowired
	private EventService eventServ;
	
	public EventController() {
		// TODO Auto-generated constructor stub
	}
	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestParam String name,@RequestParam String day, @RequestParam String repeat, @RequestParam String description) {
		//TODO: process POST request
		EventDTO nuevoProducto = new EventDTO(name, day, repeat,description);
		int estado = eventServ.create(nuevoProducto);
		if(estado == 0) {
			return new ResponseEntity<>("Event creado con exito", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Error al crear el Event", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/mostrartodo")
	public ResponseEntity<ArrayList<EventDTO>> mostrarTodo(){
		ArrayList<EventDTO> productos = eventServ.findAll();
		if(productos.isEmpty()) {
			return new ResponseEntity<ArrayList<EventDTO>>(productos, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<ArrayList<EventDTO>>(productos, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/mostrarid")
	public ResponseEntity<ArrayList<EventDTO>> mostrarId(Integer id){
		ArrayList<EventDTO> paises = eventServ.findID(id);
		if(paises.isEmpty()) {
			return new ResponseEntity<ArrayList<EventDTO>>(paises, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<ArrayList<EventDTO>>(paises, HttpStatus.ACCEPTED);
		}
	}
	

	
	@DeleteMapping("/eliminarporid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		int status = eventServ.deleteById(id);
		if(status == 0) {
			return new ResponseEntity<String>("Event eliminado con exito", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Error al eliminar el Event", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("crearconjson")
	public ResponseEntity<String> crearConJson (@RequestBody EventDTO Event) {
		int status = eventServ.create(Event);
		if(status == 0) {
			return new ResponseEntity<>("Event creado con exito", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Error al crear el Event", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/actualizarconjson")
	public ResponseEntity<String> actualizarConJson(@RequestBody EventDTO Event) {
	    int estado = eventServ.update(Event.getId(), Event);

	    if (estado == 0) {
	        return new ResponseEntity<>("Event actualizado con éxito", HttpStatus.OK);
	    } else if (estado == 2) {
	        return new ResponseEntity<>("Event no encontrado", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Error al actualizar el Event", HttpStatus.NOT_ACCEPTABLE);
	    }
	}
	
}
