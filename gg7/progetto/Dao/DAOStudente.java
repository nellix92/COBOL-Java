package com.spring.progetto.Dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.progetto.entities.Studente;

public class DAOStudente {
	
	private Map<Integer, Studente> mappa;
	private static DAOStudente instance;
	private DAOStudente(){
		this.mappa = new HashMap<>();
	}

	public static DAOStudente getInstance() {
		if(instance == null){
			instance = new DAOStudente();
		}
		return instance;
	}


	public void insert(Studente studente) {
		if(mappa.containsKey(studente.getMatricola()))
			throw new RuntimeException("studente già presente " + studente.getMatricola());
		
		mappa.put(studente.getMatricola(), studente);

	}
	

	public Boolean delete(Integer matricola) {
		Studente studente = mappa.remove(matricola);
		return studente!=null;
	}
	

	public Studente updateData(Integer matricola, Date newDate) {
		if(!mappa.containsKey(matricola)) {
			throw new RuntimeException("la matricola " + matricola +  " non è presente" );

		}
		mappa.get(matricola).setDataDiNascita(newDate);
		return mappa.get(matricola);
	}
	

	public List<Studente> selectAll(){
		return new ArrayList<>(mappa.values());
	}


	public Studente selectById(Integer matricola) {
		if(!mappa.containsKey(matricola)) {
			throw new RuntimeException("la matricola " + matricola +  " non è presente" );
		}
		return mappa.get(matricola);
	}

	
	public Studente update(Studente studente) {
		if(!mappa.containsKey(studente.getMatricola())) {
			throw new RuntimeException("la matricola " + studente.getMatricola() +  " non è presente" );
		}
		mappa.put(studente.getMatricola(), studente);
		return mappa.get(studente.getMatricola());	
	}

}
