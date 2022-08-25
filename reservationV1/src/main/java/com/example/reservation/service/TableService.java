package com.example.reservation.service;

import com.example.reservation.repo.RetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    private RetableRepo retableRepo;

    public List<String> findTableNum(){

        return retableRepo.findTableNum();
    }

    public Integer countTable(){
        return retableRepo.countTable();
    }
}
