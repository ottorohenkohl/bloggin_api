package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.Paragraph;
import de.ottorohenkohl.bloggin.domain.component.model.value.Text;
import de.ottorohenkohl.bloggin.domain.component.repository.ParagraphRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingParagraph;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshParagraph;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.IndividualMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class, Text.Mapping.class, ComponentMapper.class})
public abstract class ParagraphMapper extends IndividualMapper<Paragraph, ExistingParagraph, FreshParagraph> {
    
    @Inject
    protected ParagraphRepository repository;
}
