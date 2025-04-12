package co.edu.unbosque.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

	Optional<Event> findById(Integer id);

	Optional<Event> findByName(String name);

	Optional<Event> findByDay(String day);

	void deleteById(Integer id);

}
