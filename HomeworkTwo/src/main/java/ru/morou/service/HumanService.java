package ru.morou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.morou.entites.Human;
import ru.morou.repositories.HumanRepository;


@Service
public class HumanService {
    private HumanRepository humanRepository;

    @Autowired
    public void setHumanRepository(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public Human getHumanById(int id) {
        Human human = humanRepository.findOneById(id);
        return human;
    }

    public HumanService() {
    }
}