package de.ottorohenkohl.bloggin.domain.global.model;

import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Description;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Name;
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
public class Meta extends Individual {
    
    @NotNull
    @Valid
    private Description copyright;
    
    @NotNull
    @Valid
    private Description description;
    
    @NotNull
    @Valid
    private Name name;
}