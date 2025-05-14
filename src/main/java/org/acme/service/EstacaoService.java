package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.EstacaoEntity;
import org.acme.repository.EstacaoRepository;


import java.util.List;
import java.util.NoSuchElementException;


@ApplicationScoped
public class EstacaoService {


    private final EstacaoRepository EstacaoRepository;


    public EstacaoService(EstacaoRepository EstacaoRepository) {
        this.EstacaoRepository = EstacaoRepository;
    }

    public EstacaoEntity createEstacao(EstacaoEntity EstacaoEntity) {
        EstacaoRepository.persist(EstacaoEntity);
        return EstacaoEntity;
    }


    public List<EstacaoEntity> findAll(Integer page, Integer pageSize) {
        return EstacaoRepository.findAll()
                .page(page, pageSize)
                .list();
    }


    public EstacaoEntity findById(Integer IdEstacao) {
        return (EstacaoEntity) EstacaoRepository.findByIdOptional(IdEstacao)
                .orElseThrow(() -> new NoSuchElementException("Estação não encontrado com id: " + IdEstacao));
    }


    public EstacaoEntity updateestacao(Integer IdEstacao, EstacaoEntity EstacaoEntity) {
        var estacao = findById(IdEstacao);


        estacao.setNomeEstacao(EstacaoEntity.getNomeEstacao());
        estacao.setLocalizacao(EstacaoEntity.getLocalizacao());
        estacao.setAcessibilidade(EstacaoEntity.getAcessibilidade());

        EstacaoRepository.persist(estacao);

        return estacao;
    }


    public void deleteById(Integer IdEstacao) {
        var estacao = findById(IdEstacao);
        EstacaoRepository.deleteById(estacao.getIdEstacao());
    }
}