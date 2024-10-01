package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Alignment;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface AlignmentRepository extends MultipleRepository<Alignment> {
    
    @Override
    default Class<Alignment> getType() {
        return Alignment.class;
    }
    
    @Find
    Alignment read(Identifier identifier);
}
