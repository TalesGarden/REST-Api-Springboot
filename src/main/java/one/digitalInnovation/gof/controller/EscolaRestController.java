package one.digitalInnovation.gof.controller;

import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.model.Escola;
import one.digitalInnovation.gof.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author TalesRJardim
 */

@RestController
@RequestMapping("escolas")
public class EscolaRestController {

    @Autowired
    EscolaService escolaService;

    @GetMapping
    public ResponseEntity<Iterable<Escola>> buscarTodos(){
        return  ResponseEntity.ok(escolaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> buscarPorId(@PathVariable Long id) {
        return  ResponseEntity.ok(escolaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Escola> inserir(@RequestBody Escola escola){
        escolaService.inserir(escola);
        return ResponseEntity.ok(escola);
    }

    @PutMapping("{id}")
    public ResponseEntity<Escola> atualizar(@PathVariable Long id, @RequestBody Escola escola) {
        escolaService.atualizar(id, escola);
        return ResponseEntity.ok(escola);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        escolaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
