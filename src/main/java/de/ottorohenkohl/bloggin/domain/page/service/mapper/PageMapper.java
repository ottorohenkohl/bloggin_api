package de.ottorohenkohl.bloggin.domain.page.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.file.service.mapper.FileMapper;
import de.ottorohenkohl.bloggin.domain.page.model.Page;
import de.ottorohenkohl.bloggin.domain.page.model.value.Title;
import de.ottorohenkohl.bloggin.domain.page.repository.PageRepository;
import de.ottorohenkohl.bloggin.domain.page.service.transfer.ExistingPage;
import de.ottorohenkohl.bloggin.domain.page.service.transfer.FreshPage;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, FileMapper.class, Title.Mapping.class, ComponentMapper.class})
public abstract class PageMapper extends IndividualMapper<Page, ExistingPage, FreshPage> {
    
    @Inject
    protected PageRepository repository;
}
