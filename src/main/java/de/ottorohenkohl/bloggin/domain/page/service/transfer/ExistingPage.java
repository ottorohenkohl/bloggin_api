package de.ottorohenkohl.bloggin.domain.page.service.transfer;

import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;

public record ExistingPage(
        String identifier,
        String title,
        String layout,
        ReferIndividual background,
        ExistingComponent root
) {}