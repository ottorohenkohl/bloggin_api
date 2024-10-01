package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.Header;
import de.ottorohenkohl.bloggin.domain.component.model.value.Text;
import de.ottorohenkohl.bloggin.domain.component.repository.HeaderRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingHeader;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshHeader;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, Text.Mapping.class, ComponentMapper.class})
public abstract class HeaderMapper extends IndividualMapper<Header, ExistingHeader, FreshHeader> {
    
    @Inject
    protected HeaderRepository repository;
}
