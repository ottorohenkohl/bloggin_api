package de.ottorohenkohl.bloggin.domain.component.repository;

import de.ottorohenkohl.bloggin.domain.component.model.Image;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface ImageRepository extends MultipleRepository<Image> {
    
    @Override
    default Class<Image> getType() {
        return Image.class;
    }
    
    @Find
    Image read(Identifier identifier);
}
