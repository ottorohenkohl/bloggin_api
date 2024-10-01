package de.ottorohenkohl.bloggin.domain.global.service.transfer;

public record ExistingMeta(
        String identifier,
        String name,
        String description,
        String copyright
) {}