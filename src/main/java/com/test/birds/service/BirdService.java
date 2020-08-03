package com.test.birds.service;

import com.test.birds.entity.Bird;
import com.test.birds.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdService {

    private BirdRepository birdRepository;

    @Autowired
    public void setBirdRepository(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public List<Bird> findAll() {
        return birdRepository.findAll();
    }

    public Bird findById(String name) {
        return birdRepository.findById(name).orElse(null);
    }

    public List<Bird> findAllByName(String name) {
        return birdRepository.findAllByName(name);
    }

    public Bird createBird(Bird bird) {
       return birdRepository.saveAndFlush(bird);
    }

    public List<Bird> findAllAndSort(String attribute, String typeOfSort) {
        if (typeOfSort.equals("asc")) {
            return birdRepository.findAll(Sort.by(Sort.Direction.ASC, attribute));
        } else {
            return birdRepository.findAll(Sort.by(Sort.Direction.DESC, attribute));
        }
    }

    public List<Bird> findAllAndSortByAttributeWithLimit(String attribute, String typeOfSort, Integer offset, Integer limit) {
        Page<Bird> page;
        if (typeOfSort.equals("asc")) {
            page = birdRepository.findAll(
                    PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, attribute)));
        } else {
            page = birdRepository.findAll(
                    PageRequest.of(offset, limit, Sort.by(Sort.Direction.DESC, attribute)));
        }
        return page.getContent();
    }

    public List<Bird> findByAttributeWithOffsetAndLimit(int offset, int limit) {
        return birdRepository.findByAttributeWithOffsetAndLimit(offset, limit);
    }

    public List<Bird> findAllWithLimit(int limit) {
        return birdRepository.findAllWithLimit(limit);
    }


}
