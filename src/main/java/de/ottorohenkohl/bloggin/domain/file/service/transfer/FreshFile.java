package de.ottorohenkohl.bloggin.domain.file.service.transfer;

public record FreshFile(
        String mimetype,
        byte[] data
) {}