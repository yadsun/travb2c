package com.trav.b2c.po;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PricePolicy extends UpdatableBean {
	private static final long serialVersionUID = 1L;

	public enum Policy {
		DISCOUNT/* 打折 */, MATCH_DISCOUNT/* 满足条件打折 */,REDUCE/*减现金*/,MATCH_REDUCE/*满中条件减现金*/
	}

	public enum MatchCondition{
		Greater,Equal,Less,Greater_Or_Equal,Less_Or_Equal
	}
	
	private String name;
	private BigDecimal price;
	private Policy policy;
	private double policyValue;
	private MatchCondition matchCondition;
	private BigDecimal matchValue;
	private long goodsUid;
	private Goods goods;// 此价格政策对应的商品

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	public long getGoodsUid() {
		return goodsUid;
	}

	public void setGoodsUid(long goodsUid) {
		this.goodsUid = goodsUid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public double getPolicyValue() {
		return policyValue;
	}

	public void setPolicyValue(double policyValue) {
		this.policyValue = policyValue;
	}

	public BigDecimal getMatchValue() {
		return matchValue;
	}

	public void setMatchValue(BigDecimal matchValue) {
		this.matchValue = matchValue;
	}
	

	public MatchCondition getMatchCondition() {
		return matchCondition;
	}

	public void setMatchCondition(MatchCondition matchCondition) {
		this.matchCondition = matchCondition;
	}
	
	//根据价格政策得到最终价格
	public BigDecimal getRealTotalPrice(BigDecimal totalPrice){
		BigDecimal realTotalPrice = totalPrice;
		switch(this.policy){
		case DISCOUNT:
			realTotalPrice = realTotalPrice.multiply(BigDecimal.valueOf(policyValue)).divide(BigDecimal.ONE,2,RoundingMode.HALF_UP);
			break;
		case REDUCE:
			realTotalPrice = realTotalPrice.subtract(BigDecimal.valueOf(policyValue)).divide(BigDecimal.ONE,2,RoundingMode.HALF_UP);
			break;
		case MATCH_DISCOUNT:
			boolean match = false;
			switch(this.matchCondition){
			case Equal:
				match = (totalPrice.compareTo(matchValue) == 0);
				break;
			case Greater:
				match = (totalPrice.compareTo(matchValue) > 0);
				break;
			case Less:
				match = (totalPrice.compareTo(matchValue) < 0);
				break;
			case Greater_Or_Equal:
				match = (totalPrice.compareTo(matchValue) >= 0);
				break;
			case Less_Or_Equal:
				match = (totalPrice.compareTo(matchValue) <= 0);
				break;
			}
			if(match){
				realTotalPrice = realTotalPrice.multiply(BigDecimal.valueOf(policyValue)).divide(BigDecimal.ONE,2,RoundingMode.HALF_UP);
			}
			break;
		case MATCH_REDUCE:
			boolean match2 = false;
			switch(this.matchCondition){
			case Equal:
				match2 = (totalPrice.compareTo(matchValue) == 0);
				break;
			case Greater:
				match2 = (totalPrice.compareTo(matchValue) > 0);
				break;
			case Less:
				match2 = (totalPrice.compareTo(matchValue) < 0);
				break;
			case Greater_Or_Equal:
				match2 = (totalPrice.compareTo(matchValue) >= 0);
				break;
			case Less_Or_Equal:
				match2 = (totalPrice.compareTo(matchValue) <= 0);
				break;
			}
			
			if(match2){
				realTotalPrice = realTotalPrice.subtract(BigDecimal.valueOf(policyValue)).divide(BigDecimal.ONE,2,RoundingMode.HALF_UP);
			}
			break;
		}
		return realTotalPrice;
	}
}
