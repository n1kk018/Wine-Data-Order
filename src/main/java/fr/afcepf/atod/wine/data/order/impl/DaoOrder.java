
package fr.afcepf.atod.wine.data.order.impl;

import fr.afcepf.atod.vin.data.exception.WineErrorCode;
import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.data.order.api.IDaoOrder;
import fr.afcepf.atod.wine.entity.Customer;
import fr.afcepf.atod.wine.entity.Order;
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
    
}
