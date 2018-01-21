package com.cfw.m1212.web.manage.service;

import com.cfw.m1212.server.commons.exception.ServiceException;

public interface TempDirectoryService {

	/**
	 * 生成临时文件路径
	 * 
	 * @param 	originalFileName	原文件名
	 * @return 	String				生成的临时文件路径
	 * @throws 	ServiceException
	 */
	String generateTempFilePath(String originalFileName) throws ServiceException;
	
	/**
	 * 根据临时文件名获取临时目录中的文件地址
	 * 
	 * @param 	tempFileName		临时文件名
	 * @return 	String				临时目录中的文件地址
	 * @throws 	ServiceException
	 */
	String obtainTempFilePath(String tempFileName) throws ServiceException;
	
	/**
	 * 清除临时目录(只保留最近两天的文件夹)
	 * 
	 * @throws 	ServiceException
	 */
	void cleanTempDirectory() throws ServiceException;
	
}
