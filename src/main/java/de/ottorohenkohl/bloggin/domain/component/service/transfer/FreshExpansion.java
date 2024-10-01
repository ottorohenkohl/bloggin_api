package de.ottorohenkohl.bloggin.domain.component.service.transfer;

import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record FreshExpansion(
        ReferIndividual successor,
        ReferIndividual child,
        String type
) implements FreshComponent {
    
    @Override
    public Component fromFresh(ComponentMapper componentMapper) {
        return componentMapper.fromFresh(this);
    }
}