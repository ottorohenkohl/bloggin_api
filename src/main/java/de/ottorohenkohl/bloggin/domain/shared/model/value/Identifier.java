package de.ottorohenkohl.bloggin.domain.shared.model.value;

import jakarta.persistence.Embeddable;
import org.hibernate.validator.constraints.UUID;
import org.mapstruct.Mapper;

@Embeddable
public record Identifier(@UUID String value) {
    
    @Mapper
    public interface Mapping {
        
        default Identifier map(String value) {
            return new Identifier(value);
        }
        
        default String map(Identifier identifier) {
            return identifier.value();
        }
    }
}