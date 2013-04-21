package com.trav.b2c.dao;

import com.trav.b2c.po.Goods;

public interface GoodsMapper {
	public Goods findGoodsById(long objectUid);
	public void addGoods(Goods goods);
}
