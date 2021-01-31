/**
 * 
 */
package com.movierecom.app.datadict.dao;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.exception.DAOException;

/**
 * @author pravinsharma
 *
 */
public interface IDataDictDAO {
	public DataDictBO getById(Long id) throws DAOException;

	public DataDictBO getByName(String name) throws DAOException;
}
