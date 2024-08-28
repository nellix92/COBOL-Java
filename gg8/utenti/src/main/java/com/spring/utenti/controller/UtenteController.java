package com.spring.utenti.controller;


import com.spring.utenti.dao.DAOUtente;
import com.spring.utenti.entity.Utente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    DAOUtente daoUtente = new DAOUtente();

    @GetMapping(path="/insert", consumes = "application/json")
    public void insert(@RequestBody Utente utente) {
        daoUtente.insert(utente);
    }

    @GetMapping(path="/delete/{idUtente}")
    public Boolean delete(@PathVariable Integer idUtente) {
      return daoUtente.delete(idUtente);
    }

    @GetMapping(path="/update/{idUtente}" , produces = "application/json")
    public Utente updateMail(@PathVariable Integer idUtente, @RequestBody String newMail) {
        return daoUtente.updateMail(idUtente,newMail);

    }
    @GetMapping(path="/update", consumes = "application/json",produces = "application/json")
    public Utente update(@RequestBody Utente utente) {
        return daoUtente.update(utente);
    }

    @GetMapping(path="/search",produces = "application/json")
    public List<Utente> selectAll(){
        return daoUtente.selectAll();

    }

    @GetMapping(path="/search/{idUtente}",produces = "application/json")
    public Utente selectById(@PathVariable Integer idUtente) {
        return daoUtente.selectById(idUtente);
    }



}
