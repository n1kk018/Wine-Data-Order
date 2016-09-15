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
	private static final String REQORDERSBYCUSTOMER = "FROM Order o fetch left join FETCH o.customers WHERE o =:paramOrder";

	/**
	 * ********************************************** Fin Requetes
	 * HQLREQORDERSBYCUSTOMER
	 *************************************************/

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrdersByCustomer(Customer customer) {
		List<Order> liste = null;
		liste = getSf().getCurrentSession().createQuery(REQORDERSBYCUSTOMER).setParameter("paramOrder", customer)
				.list();
		return liste;
	}
}
