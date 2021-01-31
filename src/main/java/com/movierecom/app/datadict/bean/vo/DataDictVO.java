/**
 * 
 */
package com.movierecom.app.datadict.bean.vo;

import com.movierecom.app.bean.vo.IBaseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pravinsharma
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDictVO implements IBaseVO {
	private String name;
	
	private String description;
}
