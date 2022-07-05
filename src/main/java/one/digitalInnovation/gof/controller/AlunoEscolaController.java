package one.digitalInnovation.gof.controller;


import one.digitalInnovation.gof.model.AlunoEscola;
import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.service.AlunoEscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API) em uma
 * interface simples e coesa (API REST).
 *
 * @author TalesRJardim
 */

@RestController
@RequestMapping("alunos-escolas")
public class AlunoEscolaController {

    @Autowired
    AlunoEscolaService alunoEscolaService;

    @GetMapping
    public ResponseEntity<Iterable<AlunoEscola>> buscarTodos(){
        return  ResponseEntity.ok(alunoEscolaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEscola> buscarPorId(@PathVariable Long id) {
        return  ResponseEntity.ok(alunoEscolaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoEscola> inserir (@RequestBody AlunoEscola alunoEscola)
    {
        alunoEscolaService.inserir(alunoEscola);
        return ResponseEntity.ok(alunoEscola);
    }

    @PutMapping("{id}")
    public  ResponseEntity<AlunoEscola> atualizar (@PathVariable Long id, @RequestBody AlunoEscola alunoEscola)
    {
        alunoEscolaService.atualizar(id, alunoEscola);
        return ResponseEntity.ok(alunoEscola);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<AlunoEscola> deletar(@PathVariable Long id)
    {
        alunoEscolaService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
