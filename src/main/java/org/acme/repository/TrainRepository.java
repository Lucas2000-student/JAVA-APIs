package org.acme.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.TrainEntity;


@ApplicationScoped
public class TrainRepository implements PanacheRepositoryBase<TrainEntity, Integer> {
}

