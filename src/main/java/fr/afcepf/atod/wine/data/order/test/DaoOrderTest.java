package fr.afcepf.atod.wine.data.order.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
import fr.afcepf.atod.wine.entity.Adress;
import fr.afcepf.atod.wine.entity.Civility;
import fr.afcepf.atod.wine.entity.Customer;

public class DaoOrderTest {
	private static Logger log = Logger.getLogger(DaoOrderTest.class);
	

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		@SuppressWarnings("unused")
		IDaoOrder daoOrd = bf.getBean(IDaoOrder.class);

		
		
		
	}

}
