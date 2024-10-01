package de.ottorohenkohl.bloggin.domain.shared.model.value;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.mapstruct.Mapper;

@Embeddable
public record Description(@NotBlank @Size(min = 2, max = 64) String value) {
    
    @Mapper
    public interface Mapping {
        
        default Description map(String value) {
            return new Description(value);
        }
        
        default String map(Description description) {
            return description.value();
        }
    }
}