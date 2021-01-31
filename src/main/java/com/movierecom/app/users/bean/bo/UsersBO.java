/**
 * 
 */
package com.movierecom.app.users.bean.bo;

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
@Table(name="users")
public class UsersBO {
	@Id
	@SequenceGenerator(name="users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
	@Column(updatable = false)
	private Long id;
	
	private String username;
	
	private String passwd;
	
	@Transient
	private LocalDateTime createdat;
	
	public UsersBO(String username) {
		this.username = username;
	}
	
	public UsersBO(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}
}
