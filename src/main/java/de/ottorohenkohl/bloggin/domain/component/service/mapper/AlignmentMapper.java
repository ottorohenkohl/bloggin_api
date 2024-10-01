package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.Alignment;
import de.ottorohenkohl.bloggin.domain.component.repository.AlignmentRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingAlignment;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshAlignment;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, ComponentMapper.class})
public abstract class AlignmentMapper extends IndividualMapper<Alignment, ExistingAlignment, FreshAlignment> {
    
    @Inject
    protected AlignmentRepository repository;
}