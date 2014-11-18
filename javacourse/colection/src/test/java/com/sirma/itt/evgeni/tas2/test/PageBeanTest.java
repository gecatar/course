package com.sirma.itt.evgeni.tas2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.task2.Page;
import com.sirma.itt.evgeni.task2.PageBean;

public class PageBeanTest {

	@Test
	public void test() {
		PageBean pageBean = new PageBean();
		Page[] page;
		Object[] obj = new Object[10];
		for (int i = 0; i < 10; i++) {
			obj[i] = new Integer(i);
		}
		page = pageBean.getPages(obj, 3);
		assertTrue(pageBean.next()==page[0]);
		assertTrue(pageBean.next()==page[1]);
		assertTrue(pageBean.next()==page[2]);
		assertTrue(pageBean.next()==page[3]);
		assertTrue(pageBean.previos()==page[2]);
		assertTrue(pageBean.previos()==page[1]);
		assertTrue(pageBean.previos()==page[0]);
		assertTrue(pageBean.previos()==null);
	
	}

}
