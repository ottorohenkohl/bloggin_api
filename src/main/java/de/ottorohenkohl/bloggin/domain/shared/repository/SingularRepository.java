package de.ottorohenkohl.bloggin.domain.shared.repository;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;

public interface SingularRepository<T extends Individual> extends MultipleRepository<T> {
    
    default T read() {
        var builder = getEntityManager().getCriteriaBuilder();
        var query = builder.createQuery(getType());
        var root = query.from(getType());
        
        return getEntityManager().createQuery(query.select(root)).getSingleResult();
    }
    
    default T update(T individual) {
        var builder = getEntityManager().getCriteriaBuilder();
        var query = builder.createCriteriaDelete(getType());
        
        getEntityManager().createQuery(query).executeUpdate();
        getEntityManager().persist(individual);
        
        return individual;
    }
}