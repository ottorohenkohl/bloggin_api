package de.ottorohenkohl.bloggin.domain.component.service.mapper;

import de.ottorohenkohl.bloggin.domain.component.model.*;
import de.ottorohenkohl.bloggin.domain.component.repository.ComponentRepository;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.*;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.mapper.BaseMapper;
import jakarta.inject.Inject;
import lombok.Getter;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Getter
@Mapper(uses = {Identifier.Mapping.class})
public abstract class ComponentMapper extends BaseMapper<Component> {
    
    @Inject
    protected AlignmentMapper alignmentMapper;
    @Inject
    protected ExpansionMapper expansionMapper;
    @Inject
    protected HeaderMapper headerMapper;
    @Inject
    protected ImageMapper imageMapper;
    @Inject
    protected ParagraphMapper paragraphMapper;
    @Inject
    protected ComponentRepository repository;
    @Inject
    protected SeparatorMapper separatorMapper;
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Component individual) {
        return individual.asExisting(this);
    }
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Alignment individual) {
        return alignmentMapper.asExisting(individual);
    }
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Expansion individual) {
        return expansionMapper.asExisting(individual);
    }
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Header individual) {
        return headerMapper.asExisting(individual);
    }
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Image individual) {
        return imageMapper.asExisting(individual);
    }
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Paragraph individual) {
        return paragraphMapper.asExisting(individual);
    }
    
    @BeanMapping(qualifiedByName = "asExisting")
    public ExistingComponent asExisting(Separator individual) {
        return separatorMapper.asExisting(individual);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingComponent existing) {
        return existing.fromExisting(this);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingAlignment existing) {
        return alignmentMapper.fromExisting(existing);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingExpansion existing) {
        return expansionMapper.fromExisting(existing);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingHeader existing) {
        return headerMapper.fromExisting(existing);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingImage existing) {
        return imageMapper.fromExisting(existing);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingParagraph existing) {
        return paragraphMapper.fromExisting(existing);
    }
    
    @BeanMapping(qualifiedByName = "fromExisting")
    public Component fromExisting(ExistingSeparator existing) {
        return separatorMapper.fromExisting(existing);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshComponent fresh) {
        return fresh.fromFresh(this);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshAlignment fresh) {
        return alignmentMapper.fromFresh(fresh);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshExpansion fresh) {
        return expansionMapper.fromFresh(fresh);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshHeader fresh) {
        return headerMapper.fromFresh(fresh);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshImage fresh) {
        return imageMapper.fromFresh(fresh);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshParagraph fresh) {
        return paragraphMapper.fromFresh(fresh);
    }
    
    @BeanMapping(qualifiedByName = "fromFresh")
    public Component fromFresh(FreshSeparator fresh) {
        return separatorMapper.fromFresh(fresh);
    }
}