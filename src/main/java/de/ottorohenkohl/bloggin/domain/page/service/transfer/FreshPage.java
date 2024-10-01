package de.ottorohenkohl.bloggin.domain.page.service.transfer;

import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record FreshPage(
        String title,
        String layout,
        ReferIndividual background,
        ReferIndividual root
) {}