package de.ottorohenkohl.bloggin.domain.component.service.transfer;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.SIMPLE_NAME;

@JsonTypeInfo(use = SIMPLE_NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExistingAlignment.class),
        @JsonSubTypes.Type(value = ExistingHeader.class),
        @JsonSubTypes.Type(value = ExistingImage.class),
        @JsonSubTypes.Type(value = ExistingParagraph.class),
        @JsonSubTypes.Type(value = ExistingSeparator.class)
})
public interface ExistingComponent {
    
    Component fromExisting(ComponentMapper componentMapper);
    
    String identifier();
    
    ReferIndividual successor();
    
    String type();
}
