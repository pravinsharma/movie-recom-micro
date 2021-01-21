/**
 * 
 */
package com.movierecom.app.users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.users.bean.bo.DataDictBO;
import com.movierecom.app.users.repository.DataDictRepository;

/**
 * @author pravinsharma
 *
 */
@Component
public class DataDictDAO implements IDataDictDAO {
	
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
