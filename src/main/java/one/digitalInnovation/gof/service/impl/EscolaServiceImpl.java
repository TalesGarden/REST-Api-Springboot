package one.digitalInnovation.gof.service.impl;

import one.digitalInnovation.gof.model.*;
import one.digitalInnovation.gof.service.EscolaService;
import one.digitalInnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link one.digitalInnovation.gof.service.EscolaService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author TalesRJardim
 */

@Service
public class EscolaServiceImpl implements EscolaService {
    // Singleton: Injetar os componentes do Spring com @Autowired.

    @Autowired
    EscolaRepository escolaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Escola> buscarTodos()
    {
        return escolaRepository.findAll();
    }

    @Override
    public Escola buscarPorId(Long id) {
        return (Escola) escolaRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public void inserir(Escola escola) {
        salvarEscola(escola);
    }

    @Override
    public void atualizar(Long id, Escola escola) {
        Optional<Escola> escolaDB = escolaRepository.findById(id);
        if (escolaDB.isPresent() )
        {
            salvarEscola(escola);
        }
    }

    @Override
    public void deletar(Long id) {
        escolaRepository.deleteById(id);
    }

    public void salvarEscola(Escola escola)
    {

        // Verificar se o Endereco da Escola já existe (pelo CEP).
        String cep = escola.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        escola.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        escolaRepository.save(escola);

    }



}
