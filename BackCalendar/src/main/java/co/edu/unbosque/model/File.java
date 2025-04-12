package co.edu.unbosque.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class File {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private String name;
	@Column(unique = true)
	private String tipo;
	@Column(unique = true)
	private String file;

	public File(Integer id, String name, String tipo, String file) {
		super();
		this.id = id;
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
		return "File [id=" + id + ", name=" + name + ", tipo=" + tipo + ", file=" + file + "]";
	}


}
