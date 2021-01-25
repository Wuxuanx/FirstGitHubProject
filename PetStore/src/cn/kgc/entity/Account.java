package cn.kgc.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 * ’Àµ•¿‡
 * @author Administrator
 *
 */
public class Account {
	private Integer id;
	private Integer deal_type;
	private Integer pet_id;
	private Integer seller_id;
	private Integer buyer_id;
	private Integer price;
	private Date deal_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(Integer deal_type) {
		this.deal_type = deal_type;
	}
	public Integer getPet_id() {
		return pet_id;
	}
	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	public Integer getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(Integer buyer_id) {
		this.buyer_id = buyer_id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}
	public Account(Integer id, Integer deal_type, Integer pet_id, Integer seller_id, Integer buyer_id, Integer price,
			Timestamp deal_time) {
		super();
		this.id = id;
		this.deal_type = deal_type;
		this.pet_id = pet_id;
		this.seller_id = seller_id;
		this.buyer_id = buyer_id;
		this.price = price;
		this.deal_time = deal_time;
	}
	public Account(Integer deal_type, Integer pet_id, Integer seller_id, Integer buyer_id, Integer price,
			Timestamp deal_time) {
		super();
		this.deal_type = deal_type;
		this.pet_id = pet_id;
		this.seller_id = seller_id;
		this.buyer_id = buyer_id;
		this.price = price;
		this.deal_time = deal_time;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}	
