package fr.afcepf.atod.wine.data.order.api;

import java.util.List;

import fr.afcepf.atod.wine.data.api.IDaoGeneric;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;

public interface IDaoOrder extends IDaoGeneric<Order, Integer> {

	List<Order> getAllOrdersByCustomer(Customer customer);
	
	
}
