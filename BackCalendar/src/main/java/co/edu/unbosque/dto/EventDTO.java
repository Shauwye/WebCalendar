package co.edu.unbosque.dto;

public class EventDTO {
	private Integer id;
	private String name;
	private String day;
	private String repeat;
	private String description;

	public EventDTO() {
		// TODO Auto-generated constructor stub
	}

	public EventDTO(String name, String day, String repeat, String description) {
		super();
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
		return "EventDTO [id=" + id + ", name=" + name + ", day=" + day + ", repeat=" + repeat + ", description="
				+ description + "]";
	}

	

}
