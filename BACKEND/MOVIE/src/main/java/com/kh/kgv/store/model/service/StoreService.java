package com.kh.kgv.store.model.service;

import java.util.Map;

import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.store.model.vo.StoreOrder;

public interface StoreService {

	Map<String, Object> getStoreMap();

	Store getStoreDetail(Store store);

	int successPayment(StoreOrder storeOrder);



	


	
	

}
