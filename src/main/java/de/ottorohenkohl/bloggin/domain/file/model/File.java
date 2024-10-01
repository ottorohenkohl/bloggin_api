package de.ottorohenkohl.bloggin.domain.file.model;

import de.ottorohenkohl.bloggin.domain.file.model.value.Data;
import de.ottorohenkohl.bloggin.domain.file.model.value.Mimetype;
import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
public class File extends Individual {
    
    @NotNull
    @Valid
    private Data data;
    
    @NotNull
    @Valid
    private Mimetype mimetype;
}