package de.ottorohenkohl.bloggin.domain.component.model;

import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Expansion extends Component {
    
    @Override
    public ExistingComponent asExisting(ComponentMapper componentMapper) {
        return componentMapper.asExisting(this);
    }
}
