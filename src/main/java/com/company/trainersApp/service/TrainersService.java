
package com.company.trainersApp.service;

import com.company.trainersApp.model.Trainers;
import com.company.trainersApp.repository.TrainersRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elTok
 */
@Service
@Transactional
public class TrainersService {
    
 @Autowired 
 private TrainersRepository trainersRepo ;
 
  public List<Trainers> getAllTrainers() {
        return trainersRepo.findAll();
    }
     
    public void saveTrainers(Trainers trainer) {
        trainersRepo.save(trainer);
    }
     
    public Trainers getTrainerById(int id) {
        return trainersRepo.findById(id).get();
    }
     
    public void deleteTrainer(int id) {
        trainersRepo.deleteById(id);
    }
    
     public void updateTrainers(Trainers trainer) {
        trainersRepo.save(trainer);
    }
}

 
    
    
    
    
    

