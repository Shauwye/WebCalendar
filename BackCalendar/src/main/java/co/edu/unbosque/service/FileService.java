package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.dto.FileDTO;
import co.edu.unbosque.model.File;
import co.edu.unbosque.repository.FileRepository;


public class FileService {
	@Autowired
	private FileRepository fileRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public FileService() {
		// TODO Auto-generated constructor stub
	}
	
	public int create(FileDTO data){
		File entity = modelMapper.map(data, File.class);
		try {
			fileRepo.save(entity);
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}
	
	public ArrayList<FileDTO> findID(Integer id){
		Optional<File> entityList = fileRepo.findById(id);
		ArrayList<FileDTO> dtoList = new ArrayList<>();
		entityList.ifPresent(entity -> {
		        FileDTO dto = modelMapper.map(entity, FileDTO.class);
		        dtoList.add(dto);
		});
		return dtoList;
	}
	public int deleteById(Integer id) {
		Optional<File> found = fileRepo.findById(id);
		if(found.isPresent()) {
			fileRepo.delete(found.get());
			return 0;
		}else {
			return 1;
		}
	}
}
