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
	private Date recent_active;
	

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
	
	@Column(name="starttime",columnDefinition="timestamp")
	public Date getStarttime() {
		return starttime;
	}
	
	
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

	@Column(name="recent_active",columnDefinition="timestamp")
	public Date getRecent_active() {
		return recent_active;
	}


	public void setRecent_active(Date recent_active) {
		this.recent_active = recent_active;
	}

	
	
	

}
