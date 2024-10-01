package de.ottorohenkohl.bloggin.runtime;

import de.ottorohenkohl.bloggin.domain.file.model.File;
import de.ottorohenkohl.bloggin.domain.file.model.value.Data;
import de.ottorohenkohl.bloggin.domain.file.model.value.Mimetype;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.MediaType;
import net.bytebuddy.utility.RandomString;

@ApplicationScoped
public class FileGenerator extends BaseGenerator<File> {
    
    @Override
    public File instantiate() {
        var data = new Data(RandomString.make(30).getBytes());
        var mimetype = new Mimetype(MediaType.APPLICATION_OCTET_STREAM);
        
        return new File(data, mimetype);
    }
}
