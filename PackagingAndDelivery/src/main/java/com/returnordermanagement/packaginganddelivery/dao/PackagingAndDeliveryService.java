package com.returnordermanagement.packaginganddelivery.dao;

import org.springframework.stereotype.Service;

import com.returnordermanagement.packaginganddelivery.exception.ComponentTypeNotFound;

@Service
public interface PackagingAndDeliveryService {
	/**
	 * This method is used to check whether user entered component type is valid or
	 * not
	 * 
	 * @param token, componentType,count
	 * @throws ComponentTypeNotFound
	 * @return PackageandDelivey Cost
	 */
	public double getPackingAndDeliveryCharge(String componentType, int count) throws ComponentTypeNotFound;

}
