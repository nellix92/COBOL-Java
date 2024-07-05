package com.spring.rubrica.controller;


import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.service.RubricaServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/rubrica")
public class RubricaController {
	
	@Autowired
	RubricaServiceImpl rubricaService;


    @PostMapping(path="",consumes = "application/json")
    public void insertRubrica(@RequestBody RubricaDTO rubrica) {
        rubricaService.insertRubrica(rubrica);
    }

	@GetMapping(path="/rubriche/{idRubrica}")
    public RubricaDTO getRubricaById(@PathVariable int idRubrica) {
        return rubricaService.getRubrica(idRubrica);
    }
	 
    @DeleteMapping(path="/{idRubrica}")
    public boolean removeRubrica(@PathVariable int idRubrica) {
        return rubricaService.removeRubrica(idRubrica);
    }

    @GetMapping(path="")
    public List<RubricaDTO> getRubriche() {
        return rubricaService.getRubriche();
    }
    
    @PatchMapping(path="/{idRubrica}")
    public void updateRubricaNome(@PathVariable int idRubrica,@RequestParam String nome){
        rubricaService.updateRubricaNome(idRubrica,nome);
    }

    @GetMapping(path="/contatti/{idRubrica}/search",produces = "application/json")
    public List<ContattoDTO> getContatti(@PathVariable int idRubrica) {
        return rubricaService.getContatti(idRubrica);
    }

    //operazioni contatti
    @PostMapping(path="/{idRubrica}/contatti",produces = "application/json")
    public void inserisciContatto(@PathVariable int idRubrica,@RequestBody ContattoDTO contattoDTO){
        rubricaService.inserisciContatto(idRubrica,contattoDTO);
    }
    @PutMapping(path="/{idRubrica}/contatti",produces = "application/json")
    public void updateContatto(@PathVariable int idRubrica,@RequestBody ContattoDTO contatto){
        rubricaService.updateContatto(idRubrica,contatto);
    }

    @GetMapping(path="/contatti/{idRubrica}/search/numbers",produces = "application/json")
    public List<String> selectNumeroContatti(@PathVariable int idRubrica){
        return rubricaService.selectNumeroContatti(idRubrica);
    }
    @DeleteMapping(path="{idRubrica}/contatti/{idContatto}",produces = "application/json",consumes="application/json")
    public void deleteExistingContato(@PathVariable int idRubrica,@RequestBody ContattoDTO contatto){
        rubricaService.deleteExistingContato(idRubrica,contatto);
    }

    @GetMapping(path="/contatti/{idRubrica}/search/{idContatto}",produces = "application/json")
    public ContattoDTO searchContatto(@PathVariable int idRubrica,@PathVariable int idContatto){
        return rubricaService.searchContatto(idRubrica,idContatto);
    }

    @GetMapping(path="/{idRubrica}/contatti/numbers",produces = "application/json")
    public  List<ContattoDTO> searchContatto(@PathVariable int idRubrica,@PathVariable String numero){
        return rubricaService.searchContatto(idRubrica,numero);
    }


    @GetMapping(path="/{idRubrica}/contatti/{idContatto}",produces = "application/json")
    public  List<ContattoDTO> searchContatto(@PathVariable int idRubrica,@PathVariable String nome,@PathVariable String cognome){
        return rubricaService.searchContatto(idRubrica,nome,cognome);

    }

    @GetMapping(path="/{idRubrica}/contatti/preferiti",produces = "application/json")
    public  List<ContattoDTO> searchPreferito(@PathVariable int idRubrica){
        return rubricaService.searchContattiPreferiti(idRubrica);

    }


}