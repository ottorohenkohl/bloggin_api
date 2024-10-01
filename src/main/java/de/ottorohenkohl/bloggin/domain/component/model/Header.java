package de.ottorohenkohl.bloggin.domain.component.model;

import de.ottorohenkohl.bloggin.domain.component.model.constant.Level;
import de.ottorohenkohl.bloggin.domain.component.model.value.Text;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import jakarta.persistence.Entity;
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
public class Header extends Component {
    
    @NotNull
    private Level level;
    
    @NotNull
    @Valid
    private Text text;
    
    @Override
    public ExistingComponent asExisting(ComponentMapper componentMapper) {
        return componentMapper.asExisting(this);
    }
}
