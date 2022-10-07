package embedable;

import javax.persistence.Embeddable;

@Embeddable
public class Education {

	
	private String university;
	private String city;
	private String country;
	private int degree;
	
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	@Override
	public String toString() {
		return "Education [university=" + university + ", city=" + city + ", country=" + country + ", degree=" + degree
				+ "]";
	}
	
	
}
