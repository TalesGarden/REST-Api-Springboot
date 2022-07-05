package one.digitalInnovation.gof.service.impl;
import one.digitalInnovation.gof.model.*;
import one.digitalInnovation.gof.service.AlunoEscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link one.digitalInnovation.gof.service.AlunoEscolaService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author TalesRJardim
 */

@Service
public class AlunoEscolaServiceImpl implements AlunoEscolaService {

    // Singleton: Injetar os componentes do Spring com @Autowired.

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private AlunoEscolaRepository alunoEscolaRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    public Iterable<AlunoEscola> buscarTodos()
    {
        return alunoEscolaRepository.findAll();
    }

    @Override
    public AlunoEscola buscarPorId(Long id) {
        Optional<AlunoEscola> alunoEscola =  alunoEscolaRepository.findById(id);
        return alunoEscola.get();
    }

    @Override
    public void inserir(AlunoEscola alunoEscola) {
        alunoEscolaRepository.save(alunoEscola);
        clienteRepository.save(alunoEscola.getCliente());
        escolaRepository.save(alunoEscola.getEscola());
    }

    @Override
    public void atualizar(Long id, AlunoEscola alunoEscola) {
        Optional<AlunoEscola> escolaAlunoDB = alunoEscolaRepository.findById(id);
        if (escolaAlunoDB.isPresent() )
        {
            alunoEscolaRepository.save(alunoEscola);

        }
    }

    @Override
    public void deletar(Long id) {
        alunoEscolaRepository.deleteById(id);
    }

}
