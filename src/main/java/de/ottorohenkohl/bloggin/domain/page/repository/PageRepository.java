package de.ottorohenkohl.bloggin.domain.page.repository;

import de.ottorohenkohl.bloggin.domain.page.model.Page;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface PageRepository extends MultipleRepository<Page> {
    
    @Override
    default Class<Page> getType() {
        return Page.class;
    }
    
    @Find
    Page read(Identifier identifier);
}
