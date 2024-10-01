package de.ottorohenkohl.bloggin.domain.file.service.transfer;

public record ExistingFile(
        String identifier,
        String mimetype,
        byte[] data
) {}