package de.ottorohenkohl.bloggin.domain.component.model;

import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Component extends Individual {
    
    @Valid
    @OneToOne
    private Component successor;
    
    public abstract ExistingComponent asExisting(ComponentMapper componentMapper);
    
    public String getType() {
        return getClass().getSimpleName();
    }
}