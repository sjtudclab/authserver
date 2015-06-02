package cn.edu.sjtu.se.dclab.server.entity;

/**
 *2015年1月19日 上午10:32:42
 *@author changyi yuan
 *
 *Represents an item in inventory or in a shopping cart.
 */
public class Item {
    private Integer id;
    private String name;
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
      
}
