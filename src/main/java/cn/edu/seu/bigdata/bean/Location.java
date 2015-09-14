package cn.edu.seu.bigdata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="location")
public class Location {

	private int id;	
	//	¾­¶È
	private double lat;
	//	Î³¶È
	private double lng;	
	private String address;
	private String poi;
	private String tag;
	
	private Set<User> user = new HashSet<User>() ;
//	private Set<User> userActive = new  HashSet<User>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPoi() {
		return poi;
	}
	public void setPoi(String poi) {
		this.poi = poi;
	}
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@ManyToMany(mappedBy="location")
	public Set<User> getUser(){
		return user;
	}
	
	public void setUser(Set<User> user){
		this.user = user;
	}

}
