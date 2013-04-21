package com.trav.b2c.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.trav.b2c.dao.GoodsMapper;
import com.trav.b2c.dao.PricePolicyMapper;
import com.trav.b2c.dao.UserMapper;
import com.trav.b2c.po.Goods;
import com.trav.b2c.po.PricePolicy;
import com.trav.b2c.po.PricePolicy.MatchCondition;
import com.trav.b2c.po.User;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String mybatisConfig = "com/trav/b2c/mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sessionFactory = builder.build(inputStream);
			session = sessionFactory.openSession();
			GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
			Date now = new Date();
//			Goods goods = new Goods();
//			goods.setActive(true);
//			goods.setDateCreated(new Date());
//			goods.setName("1116005");
//			goods.setTitle("常州中华恐龙园欢乐一日游<通天塔、灵翼穿梭>");
//			goodsMapper.addGoods(goods);
//			session.commit();
			Goods gds = goodsMapper.findGoodsById(12L);
			PricePolicy pp = new PricePolicy();
			pp.setDateCreated(now);
			pp.setCreatedBy(1L);
			pp.setDateUpdated(now);
			pp.setUpdatedBy(1L);
			pp.setName("满200送20");
			pp.setPolicy(PricePolicy.Policy.MATCH_DISCOUNT);
			pp.setMatchCondition(MatchCondition.Greater);
			pp.setMatchValue(BigDecimal.valueOf(200));
			pp.setPolicyValue(20D);
			pp.setGoodsUid(gds.getObjectUid());
			PricePolicyMapper ppMapper = session.getMapper(PricePolicyMapper.class);
			ppMapper.addPricePolicy(pp);
			
			session.commit();
		} catch (IOException e) {
		} finally{
			if(session != null){
				session.close();
			}
		}
	}

}
