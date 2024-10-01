package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.Separator;
import de.ottorohenkohl.bloggin.domain.component.repository.SeparatorRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingSeparator;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshSeparator;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, ComponentMapper.class})
public abstract class SeparatorMapper extends IndividualMapper<Separator, ExistingSeparator, FreshSeparator> {
    
    @Inject
    protected SeparatorRepository repository;
}
