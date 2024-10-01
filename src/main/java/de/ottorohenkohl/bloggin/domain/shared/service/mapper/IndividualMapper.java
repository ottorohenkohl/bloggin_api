package de.ottorohenkohl.bloggin.domain.shared.service.mapper;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

public abstract class IndividualMapper<I extends Individual, E extends Record, F extends Record> extends BaseMapper<I> {
    
    @BeanMapping(qualifiedByName = "asExisting", nullValueCheckStrategy = ALWAYS)
    public abstract E asExisting(I individual);
    
    @BeanMapping(qualifiedByName = "fromExisting", nullValueCheckStrategy = ALWAYS)
    public abstract I fromExisting(E existing);
    
    @BeanMapping(qualifiedByName = "fromFresh", nullValueCheckStrategy = ALWAYS)
    public abstract I fromFresh(F fresh);
    
    @BeanMapping(qualifiedByName = "fromOverride", nullValueCheckStrategy = ALWAYS)
    public abstract I fromOverride(I overrider, @MappingTarget I overridden);
    
    @AfterMapping
    @Named("fromExisting")
    protected I afterFromExisting(@MappingTarget I individual) {
        return fromOverride(individual, getRepository().read(individual.getIdentifier()));
    }
    
    @AfterMapping
    @Named("fromFresh")
    protected I afterFromFresh(@MappingTarget I individual) {
        return getRepository().create(individual);
    }
}