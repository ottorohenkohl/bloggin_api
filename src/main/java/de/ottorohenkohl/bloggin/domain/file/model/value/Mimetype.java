package de.ottorohenkohl.bloggin.domain.file.model.value;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import org.mapstruct.Mapper;

@Embeddable
public record Mimetype(@Pattern(regexp = "[\\w+]+/[\\w+-]+") String value) {
    
    @Mapper
    public interface Mapping {
        
        default Mimetype map(String value) {
            return new Mimetype(value);
        }
        
        default String map(Mimetype mimetype) {
            return mimetype.value();
        }
    }
}