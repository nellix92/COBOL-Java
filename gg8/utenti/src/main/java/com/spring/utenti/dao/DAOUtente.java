package com.spring.utenti.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.utenti.entity.Utente;




public class DAOUtente {
	
	private Map<Integer, Utente> mappa = new HashMap<>();

	public void insert(Utente utente) {
		if(mappa.containsKey(utente.getIdUtente()))
			throw new RuntimeException("utente già presente " + utente.getIdUtente());
		
		mappa.put(utente.getIdUtente(), utente);

	}
	
	public Boolean delete(Integer idUtente) {
		Utente utente = mappa.remove(idUtente);
		return utente!=null;
	}
	

	public Utente updateMail(Integer idUtente, String newMail) {
		if(!mappa.containsKey(idUtente)) {
			return null;
		}
		mappa.get(idUtente).setMail(newMail);
		return mappa.get(idUtente);
	}
	

	public List<Utente> selectAll(){
		return new ArrayList<>(mappa.values());}


	public Utente selectById(Integer idUtente) {
		return mappa.get(idUtente);
	}


	public Utente update(Utente utente) {
		if(!mappa.containsKey(utente.getIdUtente())) {
			return null;
		}
		mappa.put(utente.getIdUtente(), utente);
		return mappa.get(utente.getIdUtente());	
	}




}