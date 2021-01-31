/**
 * 
 */
package com.movierecom.app.datadict.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.datadict.dao.IDataDictDAO;
import com.movierecom.app.exception.DAOException;
import com.movierecom.app.exception.ServiceException;

/**
 * @author pravinsharma
 *
 */
@Component
public class DataDictService implements IDataDictService {
	private static final Logger LOG = LoggerFactory.getLogger(DataDictService.class);
	
	@Autowired
	IDataDictDAO dao;

	@Override
	public DataDictBO getById(Long id) throws ServiceException {
		DataDictBO dataDictBO = null;
		
		try {
			dataDictBO = dao.getById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return dataDictBO;
	}

	@Override
	public DataDictBO getByName(String name) throws ServiceException {
		DataDictBO dataDictBO = null;
		
		try {
			dataDictBO = dao.getByName(name);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return dataDictBO;
	}
}
