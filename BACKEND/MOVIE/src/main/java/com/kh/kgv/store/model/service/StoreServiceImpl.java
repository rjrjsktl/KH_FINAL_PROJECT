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

//	@Override
//	public Map<String, Object> getStoreDetail() {
//		 List<Store> storeList = dao.getStoreList();
//
//		    Map<String, Object> storeMap = new HashMap<>();
//
//		    if (!storeList.isEmpty()) {
//		        Store singleStore = storeList.get(0);
//		        storeMap.put("storeDetail", singleStore);
//		    }
//
//		    return storeMap;
//	}
}
