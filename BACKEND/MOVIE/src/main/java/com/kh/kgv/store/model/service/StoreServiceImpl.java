package com.kh.kgv.store.model.service;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.store.contoller.StoreController;
import com.kh.kgv.store.model.dao.StoreDAO;
import com.kh.kgv.store.model.vo.StoreCoupon;
import com.kh.kgv.store.model.vo.StoreOrder;

@Service
public class StoreServiceImpl implements StoreService {
	
	private Logger logger = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreDAO dao;

	@Override
	public Map<String, Object> getStoreMap() {
		
		List<Store> storeList = dao.getStoreList();
		
		Map<String, Object> storeMap = new HashMap<String, Object>();
		
		storeMap.put("storeList", storeList);
		
		return storeMap;
	}

	@Override
	public Store getStoreDetail(Store store) {
		return dao.getStoreDetail(store);
	}

	@Override
	public int successPayment(StoreOrder storeOrder) {
		
		 int result = dao.successPayment(storeOrder); 
		 
		 int generatedOrderNo = storeOrder.getSorderNo();
		 
		 		//storeOrder.setOrderSt("Y");
		 
		 
		 
		 logger.debug(" storeOrder################ : " + storeOrder);
		 logger.debug(" generatedOrderNo################ : " + generatedOrderNo);

		    if (result > 0 && storeOrder.getOrderDetailNo() != null) {
		       
		    	int orderCount = storeOrder.getOrderCount();
		    	 if (orderCount > 0) {
		             for (int i = 0; i < orderCount; i++) {
		            	 StoreCoupon storeCoupon = new StoreCoupon();
		            	 
		            	 String couponDetailNo = "cdn_" + System.currentTimeMillis();
		            	 
		                 storeCoupon.setCouponDetailNo(couponDetailNo);
		                 storeCoupon.setSorderNo(generatedOrderNo); 
		                 
		        		                 
		                 dao.insertStoreCoupon(storeCoupon);
		            	 		               	               
		             }	                
		        }	       
		    }
		    
		    
		
		    
		    
		    return result;	
	}




	
	
}
