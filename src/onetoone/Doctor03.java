package onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_doctor")
public class Doctor03 {
    
    @Id 
    private int id;
   
    @Column(name="doctor_name")
    private String name;

    private int grade;
    
    private String email;
    
    private String branch;
    
  //eğer mappedBy kullanılmazsa her iki taraftada ilişki için bir sütun oluşur.
    @OneToOne(mappedBy = "doctor")// mappedby koymazsan stethoscope diye bir kolon olusturru
    							//yani bu iliski Steteskop sinifindaki doctor objesini set edince krulacak
    private Stethoscope stethoscope;


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


	public Stethoscope getStethoscope() {
		return stethoscope;
	}


	public void setStethoscope(Stethoscope stethoscope) {
		this.stethoscope = stethoscope;
	}


	@Override
	public String toString() {
		return "Doctor03 [id=" + id + ", name=" + name + ", grade=" + grade + ", email=" + email + 
				", branch=" + branch
				+  "]";
	}
    

	

	
    
	}