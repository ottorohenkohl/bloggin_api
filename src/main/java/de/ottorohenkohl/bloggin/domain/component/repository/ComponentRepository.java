package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface ComponentRepository extends MultipleRepository<Component> {
    
    @Override
    default Class<Component> getType() {
        return Component.class;
    }
    
    @Find
    Component read(Identifier identifier);
}
