package onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	
	@Id
	private int id;
	
	@Column(name="patient_name",nullable = false)//nullable default true olur
	private String name;
	
	private String problem;
	
	@OneToMany(mappedBy = "patient",orphanRemoval = true, cascade=CascadeType.ALL)
	private List<Appointment> appointmentList=new ArrayList<>();

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

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", problem=" + problem + ", appointmentList=" + appointmentList
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
