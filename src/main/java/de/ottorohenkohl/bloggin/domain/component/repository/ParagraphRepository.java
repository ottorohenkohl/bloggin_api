package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Paragraph;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface ParagraphRepository extends MultipleRepository<Paragraph> {
    
    @Override
    default Class<Paragraph> getType() {
        return Paragraph.class;
    }
    
    @Find
    Paragraph read(Identifier identifier);
}
