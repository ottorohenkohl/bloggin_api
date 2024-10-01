package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.Expansion;
import de.ottorohenkohl.bloggin.domain.component.repository.ExpansionRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingExpansion;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshExpansion;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, ComponentMapper.class})
public abstract class ExpansionMapper extends IndividualMapper<Expansion, ExistingExpansion, FreshExpansion> {
    
    @Inject
    protected ExpansionRepository repository;
}