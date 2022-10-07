package onetoone;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_stethoscope")
public class Stethoscope {
	
	 @Id
	 @Column(name="ste_id")//note iki tablodan tum bilgileri fetch ederken id duplicate hataasi vermemek icin yaptim
	 private int id;
	 
	 private String name;
	 
	 @OneToOne//steteskop tablosounun icine dr id  yi vericez
	 @JoinColumn(name="dr_id")//name yazdik ki kod okunabilirligi icin
	 private Doctor03 doctor;


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

	public Doctor03 getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor03 doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Stethoscope [id=" + id + ", name=" + name + ", doctor=" + doctor + "]";
	}
	 
	 

}
