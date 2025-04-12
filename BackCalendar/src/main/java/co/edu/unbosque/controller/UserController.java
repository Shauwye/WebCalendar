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

import co.edu.unbosque.dto.UserDTO;
import co.edu.unbosque.service.UserService;

@RestController
@RequestMapping ("/user")
@CrossOrigin (origins = {"*"})
public class UserController {

	@Autowired
	private UserService userServ;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestParam String name, @RequestParam String password, @RequestParam String email) {
		//TODO: process POST request
		UserDTO nuevoProducto = new UserDTO(name, password, email);
		int estado = userServ.create(nuevoProducto);
		if(estado == 0) {
			return new ResponseEntity<>("User creado con exito", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Error al crear el User", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/mostrartodo")
	public ResponseEntity<ArrayList<UserDTO>> mostrarTodo(){
		ArrayList<UserDTO> productos = userServ.findAll();
		if(productos.isEmpty()) {
			return new ResponseEntity<ArrayList<UserDTO>>(productos, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<ArrayList<UserDTO>>(productos, HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/mostrarid")
	public ResponseEntity<ArrayList<UserDTO>> mostrarId(Integer id){
		ArrayList<UserDTO> paises = userServ.findID(id);
		if(paises.isEmpty()) {
			return new ResponseEntity<ArrayList<UserDTO>>(paises, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<ArrayList<UserDTO>>(paises, HttpStatus.ACCEPTED);
		}
	}
	
//	@GetMapping("/mostrarnombre")
//	public ResponseEntity<ArrayList<UserDTO>> mostrarNombre(String nombre){
//		ArrayList<UserDTO> paises = UserServ.findName(nombre);
//		if(paises.isEmpty()) {
//			return new ResponseEntity<ArrayList<UserDTO>>(paises, HttpStatus.NO_CONTENT);
//		}else {
//			return new ResponseEntity<ArrayList<UserDTO>>(paises, HttpStatus.ACCEPTED);
//		}
//	}
	
	@DeleteMapping("/eliminarporid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		int status = userServ.deleteById(id);
		if(status == 0) {
			return new ResponseEntity<String>("User eliminado con exito", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Error al eliminar el User", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("crearconjson")
	public ResponseEntity<String> crearConJson (@RequestBody UserDTO User) {
		int status = userServ.create(User);
		if(status == 0) {
			return new ResponseEntity<>("User creado con exito", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Error al crear el User", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/actualizarconjson")
	public ResponseEntity<String> actualizarConJson(@RequestBody UserDTO User) {
	    int estado = userServ.update(User.getId(), User);

	    if (estado == 0) {
	        return new ResponseEntity<>("User actualizado con éxito", HttpStatus.OK);
	    } else if (estado == 2) {
	        return new ResponseEntity<>("User no encontrado", HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>("Error al actualizar el User", HttpStatus.NOT_ACCEPTABLE);
	    }
	}
	
}
