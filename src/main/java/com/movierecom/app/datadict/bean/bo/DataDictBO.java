/**
 * 
 */
package com.movierecom.app.datadict.bean.bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity
@Table(name="datadict")
public class DataDictBO {
	@Id
	@SequenceGenerator(name="datadict_id_seq", sequenceName = "datadict_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "datadict_id_seq")
	@Column(updatable = false)
	private Long id;
	
	private String name;
	
	private String description;
	
	@Transient
	private LocalDateTime createdat;
	
	public DataDictBO(String name) {
		this.name = name;
	}
	
	public DataDictBO(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
