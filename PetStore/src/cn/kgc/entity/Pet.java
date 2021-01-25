package cn.kgc.entity;

import java.sql.Date;
import java.sql.Timestamp;
/**
 * ≥ËŒÔ¿‡
 * @author Administrator
 *
 */
public class Pet {
	private int id;
	private String name;
	private String type_name;
	private int health;
	private int love;
	private Timestamp birthday;
	private int owner_id;
	private int store_id;
	private String type;
	private Integer price;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
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
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp date) {
		this.birthday = date;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pet(int id, String name, String type_name, int health, int love, Timestamp timestamp, int owner_id,
			int store_id) {
		super();
		this.id = id;
		this.name = name;
		this.type_name = type_name;
		this.health = health;
		this.love = love;
		this.birthday = timestamp;
		this.owner_id = owner_id;
		this.store_id = store_id;
	}
	public Pet(String name, String type_name, int health, int love, Timestamp timestamp, int owner_id, int store_id) {
		super();
		this.name = name;
		this.type_name = type_name;
		this.health = health;
		this.love = love;
		this.birthday = timestamp;
		this.owner_id = owner_id;
		this.store_id = store_id;
	}
	public Pet(int id, String name, String type_name, int health, int love, Timestamp birthday, int owner_id,
			int store_id, String type, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.type_name = type_name;
		this.health = health;
		this.love = love;
		this.birthday = birthday;
		this.owner_id = owner_id;
		this.store_id = store_id;
		this.type = type;
		this.price = price;
	}
	
	
}
