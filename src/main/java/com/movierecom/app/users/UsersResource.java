/**
 * 
 */
package com.movierecom.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movierecom.app.bean.vo.EnvelopeVO;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.users.bean.SessionPayloadVO;
import com.movierecom.app.users.bean.vo.SessionVO;
import com.movierecom.app.users.bean.vo.UsersVO;
import com.movierecom.app.users.service.ISessionService;

/**
 * @author pravinsharma
 *
 */
@RestController
public class UsersResource {
	
	@Autowired
	ISessionService sessionService;
	
	@PostMapping(value = "${spring.data.rest.base-path}/login")
	public ResponseEntity<EnvelopeVO<SessionPayloadVO>> login(@RequestBody UsersVO user) {
		System.out.println("user: " + user);
		SessionVO session = null;
		
		try {
			session = sessionService.login(user);
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return new ResponseEntity<EnvelopeVO<SessionPayloadVO>>
				(new EnvelopeVO<SessionPayloadVO>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null),
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<EnvelopeVO<SessionPayloadVO>>
			(new EnvelopeVO<SessionPayloadVO>(HttpStatus.OK.value(), "SUCCESS", 
					new SessionPayloadVO(session)),
				HttpStatus.OK);
	}
	
	@PostMapping(value = "${spring.data.rest.base-path}/logout")
	public ResponseEntity<EnvelopeVO<SessionPayloadVO>> logout(@RequestBody SessionVO session) {
		System.out.println("session: " + session);
		SessionVO _session = null;
		
		try {
			_session = sessionService.logout(session.getToken());
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return new ResponseEntity<EnvelopeVO<SessionPayloadVO>>
				(new EnvelopeVO<SessionPayloadVO>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null),
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<EnvelopeVO<SessionPayloadVO>>
			(new EnvelopeVO<SessionPayloadVO>(HttpStatus.OK.value(), "SUCCESS", 
					new SessionPayloadVO(_session)),
				HttpStatus.OK);
	}
}
