package cn.edu.seu.bigdata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="act")
public class Act {
	private int id;
	private int user_id;
	private int location_id;
	private Date times;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public Date getTimes() {
		return times;
	}
	
	@Column(name="times",columnDefinition="timestamp")
	public void setTimes(Date times) {
		this.times = times;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
