package com.spring.progetto.Controller;


import com.spring.progetto.Dao.DAOStudente;
import com.spring.progetto.entities.Studente;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/studenti")
public class StudenteController {





    DAOStudente daoStudente = DAOStudente.getInstance();

    @GetMapping(path = "/immatricola",consumes = "application/json")
    public boolean immatricolaStudente(@RequestBody Studente studente){
        //fake
        System.out.println("Sto immatricolando lo studente : " + studente);
        DAOStudente.getInstance().insert(studente);
        return true;
    }




    @GetMapping(path="/search/{matricola}",produces = "application/json")
    public Studente getStudente(@PathVariable int matricola){
        return DAOStudente.getInstance().selectById(matricola);
    }

    @GetMapping(path="/search",produces = "application/json")
    public List<Studente> getStudente(){
        return DAOStudente.getInstance().selectAll();
    }


    @GetMapping(path="/delete")
    public boolean deleteStudente(int matricola){
        return DAOStudente.getInstance().delete(matricola);
    }


    @GetMapping(path="/update",produces = "application/json",consumes = "application/json")
    public Studente updateStudente(
            @RequestBody(required = false) Date date,
            @RequestParam(required = false) Integer matricola
                                   ){
        return  DAOStudente.getInstance().updateData(matricola,date);
    }
    @GetMapping(path="/updateStudente",produces = "application/json",consumes = "application/json")
    public Studente updateStudente(@RequestBody(required = false) Studente studente) {
        return  DAOStudente.getInstance().update(studente);
    }


    @GetMapping(path="/test",produces = "application/json")
    public Date test(){
        return new Date(104,4,20);
    }




}
