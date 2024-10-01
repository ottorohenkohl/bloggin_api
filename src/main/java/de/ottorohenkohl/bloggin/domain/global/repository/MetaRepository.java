package de.ottorohenkohl.bloggin.domain.global.repository;

import de.ottorohenkohl.bloggin.domain.global.model.Meta;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.SingularRepository;
import org.hibernate.annotations.processing.Find;

public interface MetaRepository extends SingularRepository<Meta> {
    
    @Override
    default Class<Meta> getType() {
        return Meta.class;
    }
    
    @Find
    Meta read(Identifier identifier);
}