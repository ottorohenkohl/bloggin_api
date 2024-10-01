package de.ottorohenkohl.bloggin.runtime;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public abstract class BaseGenerator<T extends Individual> {
    
    @Inject
    protected EntityManager entityManager;
    @Getter
    protected List<BaseGenerator<?>> generators = new ArrayList<>();
    @Getter
    protected List<T> individuals = new ArrayList<>();
    
    protected BaseGenerator(BaseGenerator<?>... generators) {
        this.generators.addAll(List.of(generators));
    }
    
    public T generate() {
        var individual = instantiate();
        
        individuals.add(individual);
        entityManager.persist(individual);
        
        return individual;
    }
    
    public void reset() {
        generators.forEach(BaseGenerator::reset);
        individuals.clear();
    }
    
    public T single() {
        return individuals.getFirst();
    }
    
    abstract T instantiate();
}