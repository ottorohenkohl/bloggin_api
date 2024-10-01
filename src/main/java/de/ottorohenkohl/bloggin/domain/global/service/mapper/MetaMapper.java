package de.ottorohenkohl.bloggin.domain.global.service.mapper;

import de.ottorohenkohl.bloggin.domain.global.model.Meta;
import de.ottorohenkohl.bloggin.domain.global.repository.MetaRepository;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.ExistingMeta;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshMeta;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Description;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Name;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, Name.Mapping.class, Description.Mapping.class})
public abstract class MetaMapper extends IndividualMapper<Meta, ExistingMeta, FreshMeta> {
    
    @Inject
    protected MetaRepository repository;
}