package co.edu.unbosque.dto;

public class FileDTO {
	private Integer id;
	private String name;
	private String tipo;
	private String file;

	public FileDTO( String name, String tipo, String file) {
		super();
		this.name = name;
		this.tipo = tipo;
		this.file = file;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", name=" + name + ", tipo=" + tipo + ", file=" + file + "]";
	}

	
}
