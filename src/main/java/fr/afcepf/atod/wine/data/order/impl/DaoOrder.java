package fr.afcepf.atod.wine.data.order.impl;

import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DaoOrder extends DaoGeneric<Order, Integer> implements IDaoOrder {
    /*****************************************************
     *                  Requetes HQL
     ****************************************************/
     
    private static final String REQ_LIST_CMD_BYID = "SELECT DISTINCT(c) FROM Customer c "
            + "left join fetch c.orders as o left join fetch o.ordersDetail "
            + "WHERE c.id = :idCustomer";    
    
	private static final String REQORDERSBYCUSTOMER = "SELECT o FROM Order o WHERE o.customer.id = :idCustomer ORDER BY o.paidAt DESC";

    /*****************************************************
     *              Fin Requetes HQL                    
     ****************************************************/

    @Override
    public Customer ordersCustomerById(Integer idCustomer) throws WineException {
        Customer customer = null;
        if(idCustomer!=null){
        customer = (Customer)getSf().getCurrentSession()
                            .createQuery(REQ_LIST_CMD_BYID)
                            .setParameter("idCustomer", idCustomer)
                            .uniqueResult();
        if (customer.getOrders().isEmpty()) {
            throw new WineException(WineErrorCode.CA_NE_FONCTIONNE_PAS,
                    "no orders been found in the db");
        } 
        }else {
            throw new WineException(WineErrorCode.RECHERCHE_NON_PRESENTE_EN_BASE,
                "Orders from customer not referenced in the db");
        }
        return customer;
    }
    


	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrdersByCustomer(Customer customer) throws WineException{
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
