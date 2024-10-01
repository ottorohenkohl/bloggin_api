package de.ottorohenkohl.bloggin.runtime;

import de.ottorohenkohl.bloggin.domain.page.model.Page;
import de.ottorohenkohl.bloggin.domain.page.model.constant.Layout;
import de.ottorohenkohl.bloggin.domain.page.model.value.Title;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.bytebuddy.utility.RandomString;

@ApplicationScoped
public class PageGenerator extends BaseGenerator<Page> {
    
    protected final FileGenerator fileGenerator;
    protected final HeaderGenerator headerGenerator;
    
    @Inject
    public PageGenerator(FileGenerator fileGenerator, HeaderGenerator headerGenerator) {
        super(fileGenerator, headerGenerator);
        
        this.fileGenerator = fileGenerator;
        this.headerGenerator = headerGenerator;
    }
    
    @Override
    public Page instantiate() {
        var title = new Title(RandomString.make(16));
        var layout = Layout.values()[(int) (Math.random() * Layout.values().length)];
        
        return new Page(fileGenerator.generate(), layout, headerGenerator.generate(), title);
    }
}
