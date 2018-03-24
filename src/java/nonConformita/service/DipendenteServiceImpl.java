/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonConformita.service;

import java.util.Collection;
import java.util.List;
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
@Service("dipendenteService")
@Transactional
public class DipendenteServiceImpl implements DipendenteService,UserDetailsService{
@Autowired
    private DipendenteDao dao;
     
    public Dipendenti findByMatricola(String matricola) {
        return dao.findByMatricola(matricola);
    }
 
    public void saveDipendente(Dipendenti dipendente) {
        dao.saveDipendente(dipendente);
    }
 
    public void updateDipendente(Dipendenti dipendente) {
        Dipendenti entity = dao.findByMatricola(dipendente.getMatricola());
        if(entity!=null){
            entity.setPassword(dipendente.getPassword());
            entity.setNome(dipendente.getNome());
            entity.setCognome(dipendente.getCognome());
            entity.setRuolo(dipendente.getRuolo());
        }
    }
 
    public void deleteDipendente(String nome) {
        dao.deleteDipendente(nome);
    }
     
    public List<Dipendenti> findAllDipendenti() {
        return dao.findAllDipendenti();
    }
    
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		Dipendenti user = dao.findByMatricola(username);
		GrantedAuthority authoritie = buildUserAuthority(user);

		return buildUserForAuthentication(user, authoritie);
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Dipendenti user, GrantedAuthority authoritie) {
		return new User(user.getMatricola(), user.getPassword(), user.isEnabled(), true, true, true, (Collection<? extends GrantedAuthority>) authoritie);
	}

	private GrantedAuthority buildUserAuthority(Dipendenti dip) {
                
            String ruolo=String.valueOf(dip.getRuolo());
		GrantedAuthority Result = new SimpleGrantedAuthority(ruolo);

		return Result;
	}



}
