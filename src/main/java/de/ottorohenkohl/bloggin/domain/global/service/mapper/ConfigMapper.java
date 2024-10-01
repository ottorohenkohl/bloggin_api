package de.ottorohenkohl.bloggin.domain.global.service.mapper;

import de.ottorohenkohl.bloggin.domain.file.service.mapper.FileMapper;
import de.ottorohenkohl.bloggin.domain.global.model.Config;
import de.ottorohenkohl.bloggin.domain.global.repository.ConfigRepository;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.ExistingConfig;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshConfig;
import de.ottorohenkohl.bloggin.domain.page.service.mapper.PageMapper;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, FileMapper.class, PageMapper.class})
public abstract class ConfigMapper extends IndividualMapper<Config, ExistingConfig, FreshConfig> {
    
    @Inject
    protected ConfigRepository repository;
}