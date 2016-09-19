package fr.afcepf.atod.wine.data.order.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.data.order.api.IDaoShippingMethode;
import fr.afcepf.atod.wine.entity.ShippingMethod;

@Service
@Transactional
public class DaoShippingMethode extends DaoGeneric<ShippingMethod, Integer> implements IDaoShippingMethode{

}
