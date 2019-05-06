package ru.morou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.morou.entites.Human;
import ru.morou.repositories.HumansRepository;

@Service
public class HumansService {

    private HumansRepository humansRepository;

    @Autowired
    public void setHumansRepository(HumansRepository humansRepository) {
        this.humansRepository = humansRepository;
    }

//    public Human getHumanByID(int id){
//        Human human = humansRepository.findOneByID(id);
//        return human;
//    }
    public HumansService() {

    }
}
