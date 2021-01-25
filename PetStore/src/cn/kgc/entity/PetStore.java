package cn.kgc.entity;
/**
 * ≥ËŒÔ…ÃµÍ¿‡
 * @author Administrator
 *
 */
public class PetStore {
	private Integer id;
	private String name;
	private String password;
	private Integer balance;
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
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public PetStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PetStore(Integer id, String name, String password, Integer balance) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	public PetStore(String name, String password, Integer balance) {
		super();
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	
}
