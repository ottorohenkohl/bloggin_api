package de.ottorohenkohl.bloggin.domain.shared.model.value;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.mapstruct.Mapper;

@Embeddable
public record Name(@NotBlank @Size(min = 2, max = 16) String value) {
    
    @Mapper
    public interface Mapping {
        
        default Name map(String value) {
            return new Name(value);
        }
        
        default String map(Name name) {
            return name.value();
        }
    }
}