package org.abhi.springbottmockito.ServiceImpl;

import org.abhi.springbottmockito.Entity.Office;
import org.abhi.springbottmockito.Respositories.OfficeRepo;
import org.abhi.springbottmockito.Service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepo officeRepo;

    @Autowired
    public OfficeServiceImpl(OfficeRepo officeRepo) {
        this.officeRepo = officeRepo;
    }

    @Override
    public List<Office> findAll() {
        return officeRepo.findAll();
    }

    @Override
    public Office findByEpisode(int episode) {
        Optional<Office> optionalOffice = officeRepo.findById(episode);
        Office office =null;
        if (optionalOffice.isPresent()){
            office=optionalOffice.get();
        }
        return office;
    }

    @Override
    public Office saveEpisode(Office office) {
        return officeRepo.save(office);
    }

    @Override
    public Office updateEpisode(Office office) {
        return officeRepo.save(office);
    }

    @Override
    public void deleteEpisode(int episode) {
            officeRepo.deleteById(episode);
    }
}
