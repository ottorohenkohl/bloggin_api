package de.ottorohenkohl.bloggin.domain.global.repository;

import de.ottorohenkohl.bloggin.domain.global.model.Config;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.repository.SingularRepository;
import org.hibernate.annotations.processing.Find;

public interface ConfigRepository extends SingularRepository<Config> {
    
    @Override
    default Class<Config> getType() {
        return Config.class;
    }
    
    @Find
    Config read(Identifier identifier);
}