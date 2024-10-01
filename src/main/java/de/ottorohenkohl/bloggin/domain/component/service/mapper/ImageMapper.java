package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.Image;
import de.ottorohenkohl.bloggin.domain.component.repository.ImageRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingImage;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshImage;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, ComponentMapper.class})
public abstract class ImageMapper extends IndividualMapper<Image, ExistingImage, FreshImage> {
    
    @Inject
    protected ImageRepository repository;
}
