/**
 * 
 */
package com.movierecom.app.datadict.bean.mapper;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.datadict.bean.vo.DataDictVO;

/**
 * @author pravinsharma
 *
 */
public class DataDictMapper {
	public static DataDictVO fromBO(DataDictBO bo) {
		return bo!=null? new DataDictVO(bo.getName(), bo.getDescription()): null;
	}
	
	public static DataDictBO toBO(DataDictVO vo) {
		return vo!=null? new DataDictBO(vo.getName(), vo.getDescription()): null;
	}
}
