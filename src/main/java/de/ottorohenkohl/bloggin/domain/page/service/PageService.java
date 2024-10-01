package de.ottorohenkohl.bloggin.domain.page.service;

import de.ottorohenkohl.bloggin.domain.page.repository.PageRepository;
import de.ottorohenkohl.bloggin.domain.page.service.mapper.PageMapper;
import de.ottorohenkohl.bloggin.domain.page.service.transfer.ExistingPage;
import de.ottorohenkohl.bloggin.domain.page.service.transfer.FreshPage;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PageService {
    
    @Inject
    protected PageMapper pageMapper;
    @Inject
    protected PageRepository pageRepository;
    
    @Transactional
    public ExistingPage findExistingPage(String identifier) {
        return pageMapper.asExisting(pageRepository.read(new Identifier(identifier)));
    }
    
    @Transactional
    public ReferIndividual removeExistingPage(String identifier) {
        return pageMapper.asRefer(pageRepository.delete(pageRepository.read(new Identifier(identifier))));
    }
    
    @Transactional
    public ReferIndividual storeNewPage(FreshPage freshPage) {
        return pageMapper.asRefer(pageMapper.fromFresh(freshPage));
    }
    
    @Transactional
    public ReferIndividual changeExistingPage(ExistingPage existingPage) {
        return pageMapper.asRefer(pageMapper.fromExisting(existingPage));
    }
}