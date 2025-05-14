package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.TrainEntity;
import org.acme.repository.TrainRepository;


import java.util.List;
import java.util.NoSuchElementException;


@ApplicationScoped
public class TrainService {


    private final TrainRepository TrainRepository;


    public TrainService(TrainRepository TrainRepository) {
        this.TrainRepository = TrainRepository;
    }

    public TrainEntity createTrem(TrainEntity TrainEntity) {
        TrainRepository.persist(TrainEntity);
        return TrainEntity;
    }


    public List<TrainEntity> findAll(Integer page, Integer pageSize) {
        return TrainRepository.findAll()
                .page(page, pageSize)
                .list();
    }


    public TrainEntity findById(Integer IdTrem) {
        return (TrainEntity) TrainRepository.findByIdOptional(IdTrem)
                .orElseThrow(() -> new NoSuchElementException("Trem não encontrado com id: " + IdTrem));
    }


    public TrainEntity updateTrem(Integer IdTrem, TrainEntity TrainEntity) {
        var trem = findById(IdTrem);


        trem.setHorarioChegada(TrainEntity.getHorarioChegada());
        trem.setHorarioPartida(TrainEntity.getHorarioPartida());
        trem.setStatus(TrainEntity.getStatus());

        TrainRepository.persist(trem);

        return trem;
    }


    public void deleteById(Integer IdTrem) {
        var trem = findById(IdTrem);
        TrainRepository.deleteById(trem.getIdTrem());
    }
}

