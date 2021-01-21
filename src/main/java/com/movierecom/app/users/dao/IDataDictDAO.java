/**
 * 
 */
package com.movierecom.app.users.dao;

import com.movierecom.app.exception.DAOException;
import com.movierecom.app.users.bean.bo.DataDictBO;

/**
 * @author pravinsharma
 *
 */
public interface IDataDictDAO {
	public DataDictBO getById(Long id) throws DAOException;

	public DataDictBO getByName(String name) throws DAOException;
}
