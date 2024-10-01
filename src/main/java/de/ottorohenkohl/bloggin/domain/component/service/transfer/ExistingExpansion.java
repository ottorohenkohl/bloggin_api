package de.ottorohenkohl.bloggin.domain.component.service.transfer;

import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record ExistingExpansion(
        String identifier,
        String type,
        ReferIndividual successor,
        ExistingComponent child
) implements ExistingComponent {
    
    @Override
    public Component fromExisting(ComponentMapper componentMapper) {
        return componentMapper.fromExisting(this);
    }
}