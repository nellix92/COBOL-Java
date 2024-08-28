package com.spring.rubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;


public class DAORubrica {
	
	private Map<Integer,Rubrica> mappa;
	private static  DAORubrica instance;
	private DAORubrica(){
		this.mappa  = new HashMap<>();

	}

	public static DAORubrica getInstance() {
		if(instance==null)
			return new DAORubrica();
		return instance;
	}


	public Rubrica getRubrica(int idRubrica) {
		return mappa.get(idRubrica);
	}

	public void insertRubrica(Rubrica rubrica) {
		if(mappa.containsKey(rubrica.getIdRubrica()))
			throw new RuntimeException("Rubrica già presente con id " + rubrica.getIdRubrica());
		
		mappa.put(rubrica.getIdRubrica(),rubrica);
	}

	public boolean removeRubrica(int idRubrica) {
		Rubrica r = mappa.remove(idRubrica);
		return r!=null;
	}

	public List<Rubrica> getRubriche() {
		return new ArrayList<>(mappa.values());
	}

	public List<Contatto> getContatti(int idRubrica) {
		Rubrica rubrica = mappa.get(idRubrica);
		if(rubrica!=null)
			return rubrica.getContatti();
		throw new RuntimeException("Id rubrica NON presente");

	}

}
