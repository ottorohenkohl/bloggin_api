package de.ottorohenkohl.bloggin.domain.global.service.transfer;

import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record FreshConfig(
        ReferIndividual favicon,
        ReferIndividual home
) {}