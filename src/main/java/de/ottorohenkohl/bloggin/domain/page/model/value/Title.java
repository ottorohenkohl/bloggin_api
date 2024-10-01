package de.ottorohenkohl.bloggin.domain.page.model.value;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.mapstruct.Mapper;

@Embeddable
public record Title(@NotBlank @Size(min = 4, max = 24) String value) {
    
    @Mapper
    public interface Mapping {
        
        default String map(Title title) {
            return title.value();
        }
        
        default Title map(String value) {
            return new Title(value);
        }
    }
}