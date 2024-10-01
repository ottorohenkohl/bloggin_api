package de.ottorohenkohl.bloggin.runtime;

import de.ottorohenkohl.bloggin.domain.global.model.Config;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConfigGenerator extends BaseGenerator<Config> {
    
    protected final FileGenerator fileGenerator;
    protected final PageGenerator pageGenerator;
    
    @Inject
    public ConfigGenerator(FileGenerator fileGenerator, PageGenerator pageGenerator) {
        super(fileGenerator, pageGenerator);
        
        this.fileGenerator = fileGenerator;
        this.pageGenerator = pageGenerator;
    }
    
    @Override
    public Config instantiate() {
        return new Config(fileGenerator.generate(), pageGenerator.generate());
    }
}
