package de.ottorohenkohl.bloggin.runtime;

import de.ottorohenkohl.bloggin.domain.component.model.Header;
import de.ottorohenkohl.bloggin.domain.component.model.constant.Level;
import de.ottorohenkohl.bloggin.domain.component.model.value.Text;
import jakarta.enterprise.context.ApplicationScoped;
import net.bytebuddy.utility.RandomString;

@ApplicationScoped
public class HeaderGenerator extends BaseGenerator<Header> {
    
    @Override
    public Header instantiate() {
        var text = new Text(RandomString.make(16));
        
        return new Header(Level.DEFAULT, text);
    }
}
