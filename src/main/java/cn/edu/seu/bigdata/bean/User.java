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
@Table(name="user")
public class User {
	
	private int id;
	
	private String name;
	
	private String password;
	private String sex;
	private String nickname;
	private int age;
	private String tag;
	
	private Set<Location> location = new HashSet<Location>() ;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="username")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}

	
	public String getNickname(){
		return nickname;
	}
	public void setNickname(String nickname){
		this.nickname=nickname;
	}
	
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@ManyToMany
	public Set<Location> getLocation(){
		return location;
	}
	
	public void setLocation(Set<Location> location){
		this.location = location;
	}
	
	
}
