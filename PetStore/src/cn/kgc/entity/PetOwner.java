package cn.kgc.entity;
/**
 * 宠物主人类
 * @author Administrator
 *
 */
public class PetOwner {
	
	private Integer id;
	private String name;
	private String password;
	private Integer money;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public PetOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PetOwner(Integer id, String name, String password, Integer money) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	public PetOwner(String name, String password, Integer money) {
		super();
		this.name = name;
		this.password = password;
		this.money = money;
	}
	
	
	
	
	
}
