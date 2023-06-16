package com.kh.kgv.management.model.service;

import java.util.List;

import com.kh.kgv.management.model.vo.Cinema;

public interface ManagePlayService {

	List<Cinema> getAreaCinemaList(String areaName);

	

}
