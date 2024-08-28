package com.spring.rubrica.dao;

import java.util.List;

import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public interface DAORubrica {

	public Rubrica getRubrica(int idRubrica);
	public void insertRubrica(Rubrica rubrica) ;
	public boolean removeRubrica(int idRubrica);
	public List<Rubrica> getRubriche();
	public List<Contatto> getContatti(int idRubrica);
}
