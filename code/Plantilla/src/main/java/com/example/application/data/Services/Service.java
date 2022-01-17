package com.example.application.data.Services;

import com.example.application.data.entity.Imatge;
import com.example.application.data.repositories.ImatgeRepository;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class Service {
    private final ImatgeRepository imatgeRepository;

    public Service(ImatgeRepository imatgeRepository) {
        this.imatgeRepository = imatgeRepository;
    }
    public List<Imatge> findAllImages(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return imatgeRepository.findAll();
        } else {
            return imatgeRepository.search(stringFilter);
        }
    }
    public long countImatges() {
        return imatgeRepository.count();
    }

    public void deleteImatge(Imatge imatge) {
        imatgeRepository.delete(imatge);
    }

    public void saveImatge(Imatge imatge) {
        if (imatge == null) {
            System.err.println("La imatge es nula.");
            return;
        }
        imatgeRepository.save(imatge);
    }
}
