package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Header;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface HeaderRepository extends MultipleRepository<Header> {
    
    @Override
    default Class<Header> getType() {
        return Header.class;
    }
    
    @Find
    Header read(Identifier identifier);
}
