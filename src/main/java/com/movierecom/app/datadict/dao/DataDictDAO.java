/**
 * 
 */
package com.movierecom.app.datadict.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.datadict.repository.DataDictRepository;
import com.movierecom.app.exception.DAOException;

/**
 * @author pravinsharma
 *
 */
@Component
public class DataDictDAO implements IDataDictDAO {
	private static final Logger LOG = LoggerFactory.getLogger(DataDictDAO.class);
	
	@Autowired
	DataDictRepository repository;
	
	public DataDictBO getById(Long id) throws DAOException {
		DataDictBO dataDictBO = null;
		
		try {
			dataDictBO = repository.getOne(id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return dataDictBO;
	}

	public DataDictBO getByName(String name) throws DAOException {
		DataDictBO dataDictBO = null;
		
		try {
			dataDictBO = repository.getByName(name);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
		return dataDictBO;
	}
}
