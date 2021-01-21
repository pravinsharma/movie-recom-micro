/**
 * 
 */
package com.movierecom.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movierecom.app.users.bean.bo.DataDictBO;

/**
 * @author pravinsharma
 *
 */
@Repository
public interface DataDictRepository extends JpaRepository<DataDictBO, Long> {
	public DataDictBO getByName(String name);
}
