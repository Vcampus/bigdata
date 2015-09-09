package cn.edu.seu.bigdata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="act")
public class Act {
	private int id;
	private int user_id;
	private int location_id;
	private Date starttime;
	private double lasttime;
	


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
	public Date getStarttime() {
		return starttime;
	}
	
	@Column(name="starttime",columnDefinition="timestamp")
	public void setStarttime(Date times) {
		this.starttime = times;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLasttime() {
		return lasttime;
	}


	public void setLasttime(double lasttime) {
		this.lasttime = lasttime;
	}

	

}
