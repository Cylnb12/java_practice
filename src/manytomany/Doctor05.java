package manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table(name="tbl_doctor")
public class Doctor05 {
	
	@Id//@Id is used to make a variable primary key in table
	private int id;
	
	@Column(name="doctor_name")
	//@Column() is used to be able to use different names for columns
	private String name;
	
	@Column(name="doctor_grade")
	private int grade;
	
	@Transient // @Transient is used not to make a variable column
	private String email;
	
	@Column(name="doctor_branch")
	private String branch;

	@ManyToMany
	@JoinTable( name = "doctor05_patient", //column name
	            joinColumns = { @JoinColumn(name = "dr_id") }, //bu class dan gelen bilgi
	            inverseJoinColumns = { @JoinColumn(name = "pt_id") })// hedefteki class in bilgisi
	        
	private List<Patient> patientList=new ArrayList<>();

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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	@Override
	public String toString() {
		return "Doctor05 [id=" + id + ", name=" + name + ", grade=" + grade + ", email=" + email + ", branch=" + branch
				+ ", patientList=" + patientList + "]";
	}
	
	
	
}
