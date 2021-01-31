/**
 * 
 */
package com.movierecom.app.session.bean.bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.movierecom.app.datadict.bean.bo.DataDictBO;
import com.movierecom.app.users.bean.bo.UsersBO;

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
@Table(name="session")
public class SessionBO {
	@Id
	@SequenceGenerator(name="session_id_seq", sequenceName = "session_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_seq")
	@Column(updatable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private UsersBO user;
	
	@ManyToOne
	@JoinColumn(name = "activityid")
	private DataDictBO activity;
	
	@Column(updatable = false)
	private String token;
	
	@Column(updatable = false, insertable = false)
	private LocalDateTime startedat;
	
	private LocalDateTime endedat;
	
	public SessionBO(String username, String activity, String token) {
		this.user = new UsersBO(username);
		this.activity = new DataDictBO(activity);
		this.token = token;
	}
	
	public SessionBO(UsersBO user, DataDictBO activity, String token) {
		this.user = user;
		this.activity = activity;
		this.token = token;
	}
}
