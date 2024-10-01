package de.ottorohenkohl.bloggin.domain.page.model;

import de.ottorohenkohl.bloggin.domain.component.model.Component;
import de.ottorohenkohl.bloggin.domain.file.model.File;
import de.ottorohenkohl.bloggin.domain.page.model.constant.Layout;
import de.ottorohenkohl.bloggin.domain.page.model.value.Title;
import de.ottorohenkohl.bloggin.domain.shared.model.Individual;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Page extends Individual {
    
    @ManyToOne
    @Valid
    private File background;
    
    @NotNull
    private Layout layout;
    
    @OneToOne
    @Valid
    private Component root;
    
    @NotNull
    @Valid
    private Title title;
}