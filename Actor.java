package main;
import javax.persistence.*;

@Entity
@Table(name = "actor")
public class City {
	@Id
	@Column(name = "actor_id")
	int id;
	
	@Column(name = "first_name")
	String fname;
	
	@Column(name = "last_name")
	String lname;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
