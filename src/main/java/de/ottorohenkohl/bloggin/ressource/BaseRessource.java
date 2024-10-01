package de.ottorohenkohl.bloggin.ressource;

import java.net.URI;

public abstract class BaseRessource {
    
    protected URI getPath(String path, Object... args) {
        return URI.create(String.format(path, args));
    }
}