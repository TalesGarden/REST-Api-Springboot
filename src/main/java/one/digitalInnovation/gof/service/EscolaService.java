package one.digitalInnovation.gof.service;


import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.model.Escola;

public interface EscolaService {

    Iterable<Escola> buscarTodos();

    Escola buscarPorId(Long id);

    void inserir(Escola escola);

    void atualizar(Long id, Escola escola);

    void deletar(Long id);
}
