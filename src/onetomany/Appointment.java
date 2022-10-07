package onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {//child class budur

	@Id
	private int id;
	
	private String name;
	
	@ManyToOne// In child class use @ManyToOne
	@JoinColumn(name="pt_id")//id name vermeyince map etmiyor
	private Patient patient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
