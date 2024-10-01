package de.ottorohenkohl.bloggin.domain.file.repository;

import de.ottorohenkohl.bloggin.domain.file.model.File;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.MultipleRepository;
import org.hibernate.annotations.processing.Find;

public interface FileRepository extends MultipleRepository<File> {
    
    @Override
    default Class<File> getType() {
        return File.class;
    }
    
    @Find
    File read(Identifier identifier);
}
