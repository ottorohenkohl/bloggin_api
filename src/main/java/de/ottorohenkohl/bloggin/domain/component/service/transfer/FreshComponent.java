package de.ottorohenkohl.bloggin.domain.component.service.transfer;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.component.service.mapper.ComponentMapper;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

@JsonTypeInfo(use = JsonTypeInfo.Id.SIMPLE_NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FreshAlignment.class),
        @JsonSubTypes.Type(value = FreshHeader.class),
        @JsonSubTypes.Type(value = FreshImage.class),
        @JsonSubTypes.Type(value = FreshParagraph.class),
        @JsonSubTypes.Type(value = FreshSeparator.class)
})
public interface FreshComponent {
    
    Component fromFresh(ComponentMapper componentMapper);
    
    ReferIndividual successor();
    
    String type();
}
