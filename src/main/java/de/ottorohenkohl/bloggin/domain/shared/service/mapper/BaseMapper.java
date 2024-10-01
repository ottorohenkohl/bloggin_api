package de.ottorohenkohl.bloggin.domain.shared.service.mapper;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;
import org.mapstruct.BeanMapping;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

public abstract class BaseMapper<I extends Individual> {
    
    @BeanMapping(qualifiedByName = "asRefer", nullValueCheckStrategy = ALWAYS, unmappedSourcePolicy = IGNORE)
    public abstract ReferIndividual asRefer(I individual);
    
    @BeanMapping(qualifiedByName = "fromRefer", nullValueCheckStrategy = ALWAYS, unmappedTargetPolicy = IGNORE)
    public I fromRefer(ReferIndividual referIndividual) {
        return getRepository().read(new Identifier(referIndividual.identifier()));
    }
    
    protected abstract MultipleRepository<I> getRepository();
}