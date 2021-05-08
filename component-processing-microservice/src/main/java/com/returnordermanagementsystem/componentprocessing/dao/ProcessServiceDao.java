package com.returnordermanagementsystem.componentprocessing.dao;

import com.returnordermanagementsystem.componentprocessing.model.ProcessResponse;

public interface ProcessServiceDao {
	/*
	 * This method will process the the user request and will return the appropriate
	 * response
	 */
	ProcessResponse processDetails(int userId);
}
