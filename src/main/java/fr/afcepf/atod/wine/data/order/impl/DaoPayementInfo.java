package fr.afcepf.atod.wine.data.order.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.afcepf.atod.wine.data.impl.DaoGeneric;
import fr.afcepf.atod.wine.data.order.api.IDaoPaymentInfo;
import fr.afcepf.atod.wine.entity.PaymentInfo;

@Service
@Transactional
public class DaoPayementInfo extends DaoGeneric<PaymentInfo, Integer> implements IDaoPaymentInfo{

}
