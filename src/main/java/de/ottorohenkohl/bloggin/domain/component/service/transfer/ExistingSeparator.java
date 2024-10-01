package de.ottorohenkohl.bloggin.domain.component.service.transfer;

import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record ExistingSeparator(
        ReferIndividual successor,
        String identifier,
        String type,
        String direction
) implements ExistingComponent {
    
    public Component fromExisting(ComponentMapper componentMapper) {
        return componentMapper.fromExisting(this);
    }
}
