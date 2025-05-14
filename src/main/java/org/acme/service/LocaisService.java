package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.LocaisEntity;
import org.acme.repository.LocaisRepository;


import java.util.List;
import java.util.NoSuchElementException;


@ApplicationScoped
public class LocaisService {


    private final LocaisRepository LocaisRepository;


    public LocaisService(LocaisRepository LocaisRepository) {
        this.LocaisRepository = LocaisRepository;
    }

    public LocaisEntity createLocal(LocaisEntity LocaisEntity) {
        LocaisRepository.persist(LocaisEntity);
        return LocaisEntity;
    }


    public List<LocaisEntity> findAll(Integer page, Integer pageSize) {
        return LocaisRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public LocaisEntity findById(Integer IdLocal) {
        return (LocaisEntity) LocaisRepository.findByIdOptional(IdLocal)
                .orElseThrow(() -> new NoSuchElementException("Local não encontrado com id: " + IdLocal));
    }

    public LocaisEntity updateLocal(Integer IdLocal, LocaisEntity LocaisEntity) {
        var local = findById(IdLocal);

        local.setTipoLocal(LocaisEntity.getTipoLocal());
        local.setNome(LocaisEntity.getNome());
        local.setLocalizacao(LocaisEntity.getLocalizacao());
        local.setHoraAbertura(LocaisEntity.getHoraAbertura());
        local.setHoraFechamento(LocaisEntity.getHoraFechamento());
        local.setDiasFuncionamento(LocaisEntity.getDiasFuncionamento());

        LocaisRepository.persist(local);

        return local;
    }

    public void deleteById(Integer IdLocal) {
        var local = findById(IdLocal);
        LocaisRepository.deleteById(local.getIdLocal());
    }
}