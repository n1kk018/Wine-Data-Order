package fr.afcepf.atod.wine.data.order.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;

@Service
@Transactional
public class DaoOrder extends DaoGeneric<Order, Integer> implements IDaoOrder {

	/******************************************************
	 * Requetes HQL
	 ***************************************************/
	private static final String REQORDERSBYCUSTOMER = "SELECT o FROM Order o WHERE o.customer.id = :idCustomer ORDER BY o.paidAt DESC";
	/**
	 * ********************************************** Fin Requetes
	 * HQLREQORDERSBYCUSTOMER
	 *************************************************/

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrdersByCustomer(Customer customer) {
		List<Order> liste = null;
		liste = getSf().getCurrentSession().createQuery(REQORDERSBYCUSTOMER).setParameter("idCustomer", customer.getId())
				.list();
		return liste;
	}

	@Override
	public Order getLastOrderByCustomer(Customer customer) {
		Order lastOrder = new Order();
		@SuppressWarnings("unchecked")
		List<Order> orders = getSf().getCurrentSession()
				.createQuery(REQORDERSBYCUSTOMER)
				.setParameter("idCustomer", customer.getId())
				.list();
		if(!orders.isEmpty()) {
			lastOrder = orders.get(0);
		}
		return lastOrder;
	}
}
