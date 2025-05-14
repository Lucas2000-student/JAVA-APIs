package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.FaqEntity;


@ApplicationScoped
public class FaqRepository implements PanacheRepositoryBase<FaqEntity, Integer> {
}
