/**
 * 
 */
package com.movierecom.app.datadict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.datadict.bean.bo.DataDictBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface DataDictRepository extends JpaRepository<DataDictBO, Long> {
	public DataDictBO getByName(String name);
}
