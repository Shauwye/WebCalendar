package co.edu.unbosque.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findById(Integer id);

	Optional<User> findByName(String name);

	Optional<User> findByDuration(String email);

	void deleteById(Integer id);
}
