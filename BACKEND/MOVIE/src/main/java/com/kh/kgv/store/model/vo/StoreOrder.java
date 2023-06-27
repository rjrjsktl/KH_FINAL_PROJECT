package com.kh.kgv.store.model.vo;

import com.kh.kgv.items.model.vo.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrder {
	private int orderNo;
	private String orderDetailNo;
	private int orderCount;
	private String orderPrice;
	private String orderDate;
	private String otderStatus;
	
	
	
}
