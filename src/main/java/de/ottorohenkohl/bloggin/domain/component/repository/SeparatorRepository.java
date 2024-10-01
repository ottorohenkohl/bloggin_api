package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Separator;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface SeparatorRepository extends MultipleRepository<Separator> {
    
    @Override
    default Class<Separator> getType() {
        return Separator.class;
    }
    
    @Find
    Separator read(Identifier identifier);
}
