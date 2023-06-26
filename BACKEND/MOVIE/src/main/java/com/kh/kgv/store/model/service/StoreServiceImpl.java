package com.kh.kgv.store.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.kgv.items.model.vo.Store;
import com.kh.kgv.store.model.dao.StoreDAO;

@Service
public class StoreServiceImpl implements StoreService {
	
	
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
	public int getStorePayment(int totalPrice, int totalCount) {
		return dao.getStorePayment(totalPrice,totalCount);
	}

	
	
	


	
	
	
//	서비스샌드밸류1 (샌드밸류1){
	
	// 인트 리절트 = 0
	
	//리절트는 = 샌드벨류1 
	
//	/리턴 리절트
//}
	
	
}
