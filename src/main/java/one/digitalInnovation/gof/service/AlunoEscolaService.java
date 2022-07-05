package one.digitalInnovation.gof.service;


import one.digitalInnovation.gof.model.AlunoEscola;

import java.util.Optional;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de alunos e Escolas. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author TalesRJardim
 */

public interface AlunoEscolaService {

    Iterable<AlunoEscola> buscarTodos();

    AlunoEscola buscarPorId(Long id);

    void inserir(AlunoEscola alunoEscola);

    void atualizar(Long id, AlunoEscola alunoEscola);

    void deletar(Long id);

}
