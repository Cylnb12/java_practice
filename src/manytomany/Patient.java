package manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Patient {

	@Id
	private int id;

	@Column(name = "patient_name", nullable = false) // nullable default true olur
	private String name;

	private String problem;

	// kaynaktan hedefe iliski kuruldu
	@ManyToMany(mappedBy = "patientList")
	private List<Doctor05> doctors = new ArrayList<>();

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

	public List<Doctor05> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor05> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", problem=" + problem + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
