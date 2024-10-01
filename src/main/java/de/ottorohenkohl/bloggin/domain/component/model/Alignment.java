package de.ottorohenkohl.bloggin.domain.component.model;

import de.ottorohenkohl.bloggin.domain.component.model.constant.Direction;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
public class Alignment extends Component {
    
    @NotNull
    @OneToOne
    @Valid
    private Component child;
    
    @NotNull
    @Valid
    private Direction direction;
    
    @Override
    public ExistingComponent asExisting(ComponentMapper componentMapper) {
        return componentMapper.asExisting(this);
    }
}