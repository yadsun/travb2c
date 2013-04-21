package com.trav.b2c.dao;

import com.trav.b2c.po.PricePolicy;

public interface PricePolicyMapper {
	public PricePolicy findPricePolicyById(long objectUid);
	public void addPricePolicy(PricePolicy pp);
}
