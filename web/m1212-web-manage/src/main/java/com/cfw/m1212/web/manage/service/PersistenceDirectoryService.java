package com.cfw.m1212.web.manage.service;

import com.cfw.m1212.server.commons.exception.ServiceException;
public interface PersistenceDirectoryService {

	/**
	 * 生成持久化文件路径
	 * 
	 * @param	originalFileName	原文件名
	 * @param	pathProperties		配置文件中该文件存储前缀路径的属性名
	 * @return 	String				生成的持久化文件路径
	 * @throws	ServiceException
	 */
	String generatePersistenceFilePath(String originalFileName, String pathProperties) throws ServiceException;
	
	/**
	 * 根据持久化文件路径(生成的持久化文件路径)获取持久化目录中的相对root的文件地址(截断路径)
	 * 
	 * @param 	persistenceFilePath		持久化文件路径(生成的持久化文件路径)
	 * @return 	String					持久化目录中的相对root的文件地址(截断路径)
	 * @throws 	ServiceException
	 */
	String truncatePersistenceFilePath(String persistenceFilePath) throws ServiceException;
	
	/**
	 * 根据持久化文件路径(数据库中存储的路径)获取持久化目录中的文件地址
	 * 
	 * @param 	persistenceFileName		持久化文件路径(数据库中存储的路径)
	 * @return 	String					持久化目录中的文件地址
	 * @throws 	ServiceException
	 */
	String obtainPersistenceFilePath(String persistenceFileName) throws ServiceException;
}
