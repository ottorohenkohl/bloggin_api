package de.ottorohenkohl.bloggin.domain.file.service;

import de.ottorohenkohl.bloggin.domain.file.repository.FileRepository;
import de.ottorohenkohl.bloggin.domain.file.service.mapper.FileMapper;
import de.ottorohenkohl.bloggin.domain.file.service.transfer.ExistingFile;
import de.ottorohenkohl.bloggin.domain.file.service.transfer.FreshFile;
import de.ottorohenkohl.bloggin.domain.shared.model.value.Identifier;
import de.ottorohenkohl.bloggin.domain.shared.service.transfer.ReferIndividual;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FileService {
    
    @Inject
    protected FileMapper fileMapper;
    @Inject
    protected FileRepository fileRepository;
    
    @Transactional
    public ExistingFile findExistingFile(String identifier) {
        return fileMapper.asExisting(fileRepository.read(new Identifier(identifier)));
    }
    
    @Transactional
    public ReferIndividual removeExistingFile(String identifier) {
        return fileMapper.asRefer(fileRepository.delete(fileRepository.read(new Identifier(identifier))));
    }
    
    @Transactional
    public ReferIndividual storeNewFile(FreshFile freshFile) {
        return fileMapper.asRefer(fileRepository.create(fileMapper.fromFresh(freshFile)));
    }
}