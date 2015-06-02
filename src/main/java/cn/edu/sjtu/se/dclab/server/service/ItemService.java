package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.Item;

/**
 *2015年1月19日 上午10:34:18
 *@author changyi yuan
 */
public interface ItemService {
	
    public Item getItemById(Integer id);
   
    public Item createItem(Item item);
   
    public void updateItem(Item item);
   
    public void deleteItemById(Integer id);
  
}
