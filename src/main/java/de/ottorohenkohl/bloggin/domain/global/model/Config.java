package de.ottorohenkohl.bloggin.domain.global.model;

import de.ottorohenkohl.bloggin.domain.file.model.File;
import de.ottorohenkohl.bloggin.domain.page.model.Page;
import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Config extends Individual {
    
    @ManyToOne
    @NotNull
    @Valid
    private File favicon;
    
    @ManyToOne
    @NotNull
    @Valid
    private Page home;
}