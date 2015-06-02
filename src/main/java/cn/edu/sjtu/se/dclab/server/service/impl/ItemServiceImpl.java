package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Item;
import cn.edu.sjtu.se.dclab.server.mapper.ItemMapper;
import cn.edu.sjtu.se.dclab.server.service.ItemService;

/**
 * 2015年1月19日 上午10:35:03
 *
 * @author changyi yuan
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;

	public ItemMapper getItemMapper() {
		return itemMapper;
	}

	public void setItemMapper(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	@Override
	public Item getItemById(Integer id) {
		return itemMapper.getItemById(id);
	}

	@Override
	public Item createItem(Item item) {
		return itemMapper.createItem(item);
	}

	@Override
	public void updateItem(Item item) {
	}

	@Override
	public void deleteItemById(Integer id) {
	}

}
