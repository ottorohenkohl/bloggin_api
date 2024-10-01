package de.ottorohenkohl.bloggin.domain.file.service.mapper;

import de.ottorohenkohl.bloggin.domain.file.model.File;
import de.ottorohenkohl.bloggin.domain.file.model.value.Data;
import de.ottorohenkohl.bloggin.domain.file.model.value.Mimetype;
import de.ottorohenkohl.bloggin.domain.file.repository.FileRepository;
import de.ottorohenkohl.bloggin.domain.file.service.transfer.ExistingFile;
import de.ottorohenkohl.bloggin.domain.file.service.transfer.FreshFile;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, Mimetype.Mapping.class, Data.Mapping.class})
public abstract class FileMapper extends IndividualMapper<File, ExistingFile, FreshFile> {
    
    @Inject
    protected FileRepository repository;
}
