package de.ottorohenkohl.bloggin.domain.file.model.value;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import org.mapstruct.Mapper;

@Embeddable
public record Data(@NotEmpty @Lob byte[] value) {
    
    @Mapper
    public static abstract class Mapping {
        
        public byte[] map(Data data) {
            return data.value();
        }
        
        public Data map(byte[] value) {
            return new Data(value);
        }
    }
}