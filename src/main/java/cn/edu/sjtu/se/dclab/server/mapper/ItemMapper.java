package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Item;

/**
 *2015年1月19日 上午10:37:21
 *@author changyi yuan
 */
public interface ItemMapper {
	
	public Item getItemById(Integer id);
	   
    public Item createItem(Item item);
   
    public void updateItem(Item item);
   
    public void deleteItemById(Integer id);
   
}
