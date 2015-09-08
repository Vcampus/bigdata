package cn.edu.seu.bigdata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String name;
	
	private String password;
	private String sex;
	private String nickname;
	private int age;
	


	private int taga;
	private int tagb;
	private int tagc;
	private int tagd;
	private int tage;
	private int tagf;
	private int tagg;
	private int tagh;
	private int tagi;
	private int tagj;
	
	
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
	
	public int getTaga() {
		return taga;
	}
	public void setTaga(int taga) {
		this.taga = taga;
	}
	public int getTagb() {
		return tagb;
	}
	public void setTagb(int tagb) {
		this.tagb = tagb;
	}
	public int getTagc() {
		return tagc;
	}
	public void setTagc(int tagc) {
		this.tagc = tagc;
	}
	public int getTagd() {
		return tagd;
	}
	public void setTagd(int tagd) {
		this.tagd = tagd;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public int getTagf() {
		return tagf;
	}
	public void setTagf(int tagf) {
		this.tagf = tagf;
	}
	public int getTagg() {
		return tagg;
	}
	public void setTagg(int tagg) {
		this.tagg = tagg;
	}
	public int getTagh() {
		return tagh;
	}
	public void setTagh(int tagh) {
		this.tagh = tagh;
	}
	public int getTagi() {
		return tagi;
	}
	public void setTagi(int tagi) {
		this.tagi = tagi;
	}
	public int getTagj() {
		return tagj;
	}
	public void setTagj(int tagj) {
		this.tagj = tagj;
	}
	
	
}
