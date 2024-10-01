package de.ottorohenkohl.bloggin.domain.shared.repository;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import jakarta.persistence.EntityManager;

public interface IndividualRepository<T extends Individual> {
    
    EntityManager getEntityManager();
    
    Class<T> getType();
    
    T read(Identifier identifier);
}
