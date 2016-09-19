package fr.afcepf.atod.wine.data.order.test;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;
import fr.afcepf.atod.wine.entity.OrderDetail;
import fr.afcepf.atod.wine.entity.Product;
import java.util.List;
import java.util.logging.Level;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronan
 */
public class testDaoOrder {
    private static Logger log = Logger.getLogger(testDaoOrder.class);
    public static void main(String[] args) {
        log.info("\t # Debut du test #");
        try {
            BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
            Integer i = 1;
            IDaoOrder daoOrder = (IDaoOrder)bf.getBean(IDaoOrder.class);
           
            log.info("\t # derniere commande: #");
            Customer c = daoOrder.ordersCustomerById(i);
            
           for (Order o : c.getOrders()) {
               log.info(o.getPaymentInfo().getPaymentMethod());
               for (OrderDetail od : o.getOrdersDetail()) {
               }
           }
        } catch (WineException ex) {
            java.util.logging.Logger.getLogger(testDaoOrder
                    .class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
