package de.ottorohenkohl.bloggin.domain.component.service;

import de.ottorohenkohl.bloggin.domain.component.repository.ComponentRepository;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshComponent;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ComponentService {
    
    @Inject
    protected ComponentMapper componentMapper;
    @Inject
    protected ComponentRepository componentRepository;
    
    @Transactional
    public ReferIndividual changeExistingComponent(ExistingComponent existingComponent) {
        return componentMapper.asRefer(componentMapper.fromExisting(existingComponent));
    }
    
    public ExistingComponent findExistingComponent(String identifier) {
        return componentMapper.asExisting(componentRepository.read(new Identifier(identifier)));
    }
    
    @Transactional
    public ReferIndividual storeNewComponent(FreshComponent freshComponent) {
        return componentMapper.asRefer(componentMapper.fromFresh(freshComponent));
    }
    
    @Transactional
    public ReferIndividual removeExistingComponent(String identifier) {
        return componentMapper.asRefer(componentRepository.delete(componentRepository.read(new Identifier(identifier))));
    }
    
}
