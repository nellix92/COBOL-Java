package com.spring.rubrica.controller;


import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.service.RubricaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/rubrica")
public class RubricaController {

    RubricaService rubricaService = RubricaService.getInstance();


    @GetMapping(path="/insert",consumes = "application/json")
    public void insertRubrica(@RequestBody RubricaDTO rubrica) {
        rubricaService.insertRubrica(rubrica);
    }

    @GetMapping(path="/search/{idRubrica}",produces = "application/json")
    public RubricaDTO getRubricaById(@PathVariable int idRubrica) {
        return rubricaService.getRubrica(idRubrica);
    }
    @GetMapping(path="/delete/{idRubrica}")
    public boolean removeRubrica(@PathVariable int idRubrica) {
        return rubricaService.removeRubrica(idRubrica);
    }

    @GetMapping(path="/search")
    public List<RubricaDTO> getRubriche() {
        return rubricaService.getRubriche();
    }

    @GetMapping(path="/contatti/{idRubrica}/search",produces = "application/json")
    public List<ContattoDTO> getContatti(@PathVariable int idRubrica) {
        return rubricaService.getContatti(idRubrica);
    }

    //operazioni contatti
    @GetMapping(path="/contatti/{idRubrica}/insert",produces = "application/json")
    public void inserisciContatto(@PathVariable int idRubrica,@RequestBody ContattoDTO contattoDTO){
        rubricaService.inserisciContatto(idRubrica,contattoDTO);
    }
    @GetMapping(path="/contatti/{idRubrica}/update",produces = "application/json")
    public void updateContatto(@PathVariable int idRubrica,@RequestBody ContattoDTO contatto){
        rubricaService.updateContatto(idRubrica,contatto);
    }

    @GetMapping(path="/contatti/{idRubrica}/search/numbers",produces = "application/json")
    public List<String> selectNumeroContatti(@PathVariable int idRubrica){
        return rubricaService.selectNumeroContatti(idRubrica);
    }
    @GetMapping(path="/contatti/{idRubrica}/delete",produces = "application/json",consumes="application/json")
    public void deleteExistingContato(@PathVariable int idRubrica,@RequestBody ContattoDTO contatto){
        rubricaService.deleteExistingContato(idRubrica,contatto);
    }



    @GetMapping(path="/contatti/{idRubrica}/search/{idContatto}",produces = "application/json")
    public ContattoDTO searchContatto(@PathVariable int idRubrica,@PathVariable int idContatto){
        return rubricaService.searchContatto(idRubrica,idContatto);
    }

    @GetMapping(path="/contatti/{idRubrica}/search/numbers/{numero}",produces = "application/json")
    public  List<ContattoDTO> searchContatto(@PathVariable int idRubrica,@PathVariable String numero){
        return rubricaService.searchContatto(idRubrica,numero);
    }


    @GetMapping(path="/contatti/{idRubrica}/search/{nome}/{cognome}",produces = "application/json")
    public  List<ContattoDTO> searchContatto(@PathVariable int idRubrica,@PathVariable String nome,@PathVariable String cognome){
        return rubricaService.searchContatto(idRubrica,nome,cognome);

    }

    @GetMapping(path="/contatti/{idRubrica}/search/preferiti",produces = "application/json")
    public  List<ContattoDTO> searchPreferito(@PathVariable int idRubrica){
        return rubricaService.searchContattiPreferiti(idRubrica);

    }


}
