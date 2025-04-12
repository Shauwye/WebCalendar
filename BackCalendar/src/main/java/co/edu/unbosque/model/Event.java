package co.edu.unbosque.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Event {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private String name;
	@Column(unique = true)
	private String day;
	@Column(unique = true)
	private String repeat;
	private String description;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(Integer id, String name, String day, String repeat, String description) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
		this.repeat = repeat;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}



	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", day=" + day + ", repeat=" + repeat + ", description="
				+ description + "]";
	}

	

}
