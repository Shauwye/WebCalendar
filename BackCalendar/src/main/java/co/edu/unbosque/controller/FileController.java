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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.dto.FileDTO;
import co.edu.unbosque.service.FileService;

@RestController
@RequestMapping ("/file")
@CrossOrigin (origins = {"*"})
public class FileController {
@Autowired
private FileService fileServ;
public FileController() {
	// TODO Auto-generated constructor stub
}
@PostMapping("/crear")
public ResponseEntity<String> crear(@RequestParam String name, @RequestParam String tipo, @RequestParam String file) {
	//TODO: process POST request
	FileDTO nuevoProducto = new FileDTO(name, tipo, file);
	int estado = fileServ.create(nuevoProducto);
	if(estado == 0) {
		return new ResponseEntity<>("Archivo creado con exito", HttpStatus.CREATED);
	}else {
		return new ResponseEntity<>("Error al crear el archivo", HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping("/mostrarid")
public ResponseEntity<ArrayList<FileDTO>> mostrarId(Integer id){
	ArrayList<FileDTO> paises = fileServ.findID(id);
	if(paises.isEmpty()) {
		return new ResponseEntity<ArrayList<FileDTO>>(paises, HttpStatus.NO_CONTENT);
	}else {
		return new ResponseEntity<ArrayList<FileDTO>>(paises, HttpStatus.ACCEPTED);
	}
}
@DeleteMapping("/eliminarporid/{id}")
public ResponseEntity<String> deleteById(@PathVariable Integer id) {
	int status = fileServ.deleteById(id);
	if(status == 0) {
		return new ResponseEntity<String>("Archivo eliminado con exito", HttpStatus.ACCEPTED);
	}else {
		return new ResponseEntity<String>("Error al eliminar el archivo", HttpStatus.NOT_FOUND);
	}
}
@PostMapping("crearconjson")
public ResponseEntity<String> crearConJson (@RequestBody FileDTO File) {
	int status = fileServ.create(File);
	if(status == 0) {
		return new ResponseEntity<>("Archivo creado con exito", HttpStatus.CREATED);
	}else {
		return new ResponseEntity<>("Error al crear el archivo", HttpStatus.NOT_ACCEPTABLE);
	}
}
}
