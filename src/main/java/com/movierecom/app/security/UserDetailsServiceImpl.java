/**
 * 
 */
package com.movierecom.app.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movierecom.app.users.bean.bo.UsersBO;
import com.movierecom.app.users.repository.UsersRepository;

/**
 * @author pravinsharma
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersBO usersBO = usersRepository.getByUsername(username);
        
        if (usersBO == null) {
            throw new UsernameNotFoundException(username);
        }
        
        return new User(usersBO.getUsername(), usersBO.getPasswd(), Collections.emptyList());
    }
}
