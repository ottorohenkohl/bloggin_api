package de.ottorohenkohl.bloggin.domain.component.service.transfer;

import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record ExistingHeader(
        String identifier,
        String type,
        String level,
        String text,
        ReferIndividual successor
) implements ExistingComponent {
    
    @Override
    public Component fromExisting(ComponentMapper componentMapper) {
        return componentMapper.fromExisting(this);
    }
}
