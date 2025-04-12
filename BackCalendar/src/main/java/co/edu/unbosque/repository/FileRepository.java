package co.edu.unbosque.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.model.File;

public interface FileRepository extends CrudRepository<File, Integer> {

	Optional<File> findById(Integer id);

	void deleteById(Integer id);
}
