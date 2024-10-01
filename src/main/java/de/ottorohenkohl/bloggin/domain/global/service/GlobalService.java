package de.ottorohenkohl.bloggin.domain.global.service;

import de.ottorohenkohl.bloggin.domain.global.repository.ConfigRepository;
import de.ottorohenkohl.bloggin.domain.global.repository.MetaRepository;
import de.ottorohenkohl.bloggin.domain.global.service.mapper.ConfigMapper;
import de.ottorohenkohl.bloggin.domain.global.service.mapper.MetaMapper;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.ExistingConfig;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.ExistingMeta;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshConfig;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshMeta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GlobalService {
    
    @Inject
    protected ConfigMapper configMapper;
    @Inject
    protected ConfigRepository configRepository;
    @Inject
    protected MetaMapper metaMapper;
    @Inject
    protected MetaRepository metaRepository;
    
    @Transactional
    public ExistingConfig findExistingConfig() {
        return configMapper.asExisting(configRepository.read());
    }
    
    @Transactional
    public ExistingMeta findExistingMeta() {
        return metaMapper.asExisting(metaRepository.read());
    }
    
    @Transactional
    public ExistingConfig replaceExistingConfig(FreshConfig freshConfig) {
        return configMapper.asExisting(configMapper.fromFresh(freshConfig));
    }
    
    @Transactional
    public ExistingMeta replaceExistingMeta(FreshMeta freshMeta) {
        return metaMapper.asExisting(metaMapper.fromFresh(freshMeta));
    }
}