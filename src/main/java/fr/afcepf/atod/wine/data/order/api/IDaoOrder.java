package fr.afcepf.atod.wine.data.order.api;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.api.IDaoGeneric;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronan
 */
public interface IDaoOrder extends IDaoGeneric<Order, Integer> {

	List<Order> getAllOrdersByCustomer(Customer customer) throws WineException;
	Order getLastOrderByCustomer(Customer customer);
	

    /**
     * recuperer les commande du customer
     *
     * @return
     * @throws WineException
     */
    Customer ordersCustomerById(Integer idCustumer) throws WineException;

}
