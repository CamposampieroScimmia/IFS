/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.Collection;
import nonConformita.dao.DipendenteDao;
import nonConformita.model.Dipendenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FSEVERI\lucangeli3503
 */

@Service("userDetailsService")
@Transactional
public class MyUserDetails implements UserDetailsService{
    
    @Autowired
    private DipendenteDao dao;
     
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		Dipendenti user = dao.findByMatricola(username);
		GrantedAuthority authoritie = buildUserAuthority(user);

		return buildUserForAuthentication(user, authoritie);
		
	}

	private User buildUserForAuthentication(Dipendenti user, GrantedAuthority authoritie) {
		return new User(user.getMatricola(), user.getPassword(), user.isEnabled(), true, true, true, (Collection<? extends GrantedAuthority>) authoritie);
	}

	private GrantedAuthority buildUserAuthority(Dipendenti dip) {
                
            String ruolo=String.valueOf(dip.getRuolo());
		GrantedAuthority Result = new SimpleGrantedAuthority(ruolo);

		return Result;
	}
}
