package org.tnsindia.collectiondi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
         ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
         CollectionType def = (CollectionType) ap.getBean("def");
         def.display();
	}

}
