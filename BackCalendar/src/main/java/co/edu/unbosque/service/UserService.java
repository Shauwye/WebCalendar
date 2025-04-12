package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.dto.UserDTO;
import co.edu.unbosque.model.User;
import co.edu.unbosque.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public int create(UserDTO data){
		User entity = modelMapper.map(data, User.class);
		try {
			userRepo.save(entity);
			return 0;
		} catch (Exception e) {
			return 1;
			// TODO: handle exception
		}
	}
	public ArrayList<UserDTO> findAll(){
		ArrayList<User> entityList = (ArrayList<User>) userRepo.findAll();
		ArrayList<UserDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity)->{
			UserDTO dto = modelMapper.map(entity, UserDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}
	public ArrayList<UserDTO> findID(Integer id){
		Optional<User> entityList = userRepo.findById(id);
		ArrayList<UserDTO> dtoList = new ArrayList<>();
		entityList.ifPresent(entity -> {
		        UserDTO dto = modelMapper.map(entity, UserDTO.class);
		        dtoList.add(dto);
		});
		return dtoList;
	}
	public int deleteById(Integer id) {
		Optional<User> found = userRepo.findById(id);
		if(found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		}else {
			return 1;
		}
	}
	public int update(Integer id, UserDTO data) {
	    Optional<User> optionalUser = userRepo.findById(id);
	    
	    if (optionalUser.isPresent()) {
	        User existingUser = optionalUser.get();
	        
	        // Actualizar solo los campos necesarios
	        existingUser.setName(data.getName());
	        existingUser.setPassword(data.getPassword());
	       
	   

	        try {
	            userRepo.save(existingUser);
	            return 0; // Éxito
	        } catch (Exception e) {
	            return 1; // Error en la actualización
	        }
	    } else {
	        return 2; // No se encontró el pasajero con ese ID
	    }
	}
	
	public int contar() {
		return (int) userRepo.count();
	}
	
}
