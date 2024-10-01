package de.ottorohenkohl.bloggin.domain.shared.repository;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;

public interface MultipleRepository<T extends Individual> extends IndividualRepository<T> {
    
    default T create(T individual) {
        getEntityManager().persist(individual);
        
        return individual;
    }
    
    default T delete(T individual) {
        getEntityManager().remove(individual);
        
        return individual;
    }
}