package de.ottorohenkohl.bloggin.domain.shared.model;

import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@MappedSuperclass
public abstract class Individual {
    
    @EmbeddedId
    @NotNull
    protected Identifier identifier = new Identifier(UUID.randomUUID().toString());
}