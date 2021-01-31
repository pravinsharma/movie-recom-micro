/**
 * 
 */
package com.movierecom.app.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movierecom.app.bean.vo.EnvelopeVO;
import com.movierecom.app.bean.vo.PayloadVO;
import com.movierecom.app.exception.ServiceException;
import com.movierecom.app.session.bean.vo.SessionVO;
import com.movierecom.app.session.service.ISessionService;
import com.movierecom.app.users.bean.vo.UsersVO;

/**
 * @author pravinsharma
 *
 */
@RestController
public class SessionResource {
	private static final Logger LOG = LoggerFactory.getLogger(SessionResource.class);
	
	@Autowired
	ISessionService sessionService;
	
	@PostMapping(value = "${spring.data.rest.base-path}/auth/login")
	public ResponseEntity<EnvelopeVO<PayloadVO>> login(@RequestBody UsersVO user) {
		LOG.debug("user: " + user);
		SessionVO session = null;
		
		try {
			session = sessionService.login(user);
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return new ResponseEntity<EnvelopeVO<PayloadVO>>
				(new EnvelopeVO<PayloadVO>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null),
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<EnvelopeVO<PayloadVO>>
			(new EnvelopeVO<PayloadVO>(HttpStatus.OK.value(), "SUCCESS", 
					new PayloadVO(new SessionVO[] { session })),
				HttpStatus.OK);
	}
	
	@PostMapping(value = "${spring.data.rest.base-path}/auth/logout")
	public ResponseEntity<EnvelopeVO<PayloadVO>> logout(@RequestBody SessionVO session) {
		System.out.println("session: " + session);
		SessionVO _session = null;
		
		try {
			_session = sessionService.logout(session.getToken());
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return new ResponseEntity<EnvelopeVO<PayloadVO>>
				(new EnvelopeVO<PayloadVO>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null),
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<EnvelopeVO<PayloadVO>>
			(new EnvelopeVO<PayloadVO>(HttpStatus.OK.value(), "SUCCESS", 
					new PayloadVO(new SessionVO[] { _session })),
				HttpStatus.OK);
	}
}
