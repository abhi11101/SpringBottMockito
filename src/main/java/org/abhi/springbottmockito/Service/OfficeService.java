package org.abhi.springbottmockito.Service;

import org.abhi.springbottmockito.Entity.Office;

import java.util.List;

public interface OfficeService {

    List<Office> findAll();

    Office findByEpisode(int episode);

    Office saveEpisode(Office office);

    Office updateEpisode(Office office);

    void deleteEpisode(int episode);
}
