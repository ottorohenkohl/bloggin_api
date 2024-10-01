package de.ottorohenkohl.bloggin.domain.component.model.value;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.mapstruct.Mapper;

@Embeddable
public record Text(@NotBlank @Size(min = 4, max = 10240) String value) {
    
    @Mapper
    public interface Mapping {
        
        default String map(Text text) {
            return text.value();
        }
        
        default Text map(String value) {
            return new Text(value);
        }
    }
}