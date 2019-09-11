
package com.company.trainersApp.repository;

import com.company.trainersApp.model.Trainers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elTok
 */
@Repository
public interface TrainersRepository extends JpaRepository<Trainers,Integer> {

   

    
    
}
