/**
 * 
 */
package com.movierecom.app.datadict.service;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.exception.ServiceException;

/**
 * @author pravinsharma
 *
 */
public interface IDataDictService {
	public DataDictBO getById(Long id) throws ServiceException;
	
	public DataDictBO getByName(String name) throws ServiceException;
}
