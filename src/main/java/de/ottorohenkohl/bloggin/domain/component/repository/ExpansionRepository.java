package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Expansion;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface ExpansionRepository extends MultipleRepository<Expansion> {
    
    @Override
    default Class<Expansion> getType() {
        return Expansion.class;
    }
    
    @Find
    Expansion read(Identifier identifier);
}
