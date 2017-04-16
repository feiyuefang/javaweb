package com.fang.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fang.pojo.TbUser;
import com.fang.pojo.TbUserExample;

public class ItemsMapperTest{

	private TbUserMapper itemsMapper;

	@Before
	public void setup() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/spring-mybatis.xml");
		itemsMapper = (TbUserMapper) applicationContext.getBean("tbUserMapper");
	}

	@Test
	public void testSelectByPrimaryKey() {
		TbUser user = itemsMapper.selectByPrimaryKey("");
		System.out.println(user.toString());
	}

	@Test
	public void testSelectByExample() {
		TbUserExample itemsExample = new TbUserExample();
		TbUserExample.Criteria criteria = itemsExample.createCriteria();
	//	criteria.(new Date());
		
		List<TbUser> list = itemsMapper.selectByExample(itemsExample);
		for (int i = 0; i < list.size(); i++) {
			TbUser it = list.get(i);
		//	System.out.println(it.getUid() + ":" + it.getUaername());
		}
	}
}
