
package com.company.trainersApp.controller;

import com.company.trainersApp.model.Trainers;
import com.company.trainersApp.service.TrainersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author elTok
 */
@Controller
public class TrainersController {
    
    @Autowired
    private TrainersService trainersService;
    
   
    
   @RequestMapping(value = "/getAllTrainers", method = RequestMethod.GET)
        
         public String getTrainers(ModelMap model) {
            
        List listOfTrainers = trainersService.getAllTrainers();
                model.addAttribute("trainer", new Trainers());
		model.addAttribute("listOfTrainers", listOfTrainers);
		return "trainersDetails";
         }
         
        @RequestMapping(value = "/getTrainer/{id}", method = RequestMethod.GET)
	public Trainers getTrainer(@PathVariable("id") Integer id) {
		return trainersService.getTrainerById(id);
	}
        
        
       @RequestMapping(value = "/addTrainer", method = RequestMethod.POST)
	public String addTrainer(@ModelAttribute("trainer") Trainers trainer) {	
            
           if(trainer.getId()==null) {
          
	   trainersService.saveTrainers(trainer);
           }
           else {
           
           trainersService.updateTrainers(trainer);
           }
            return "redirect:/getAllTrainers";

            }
 
	@RequestMapping(value = "/updateTrainer/{id}", method = RequestMethod.GET)
	public String updateTrainer(@PathVariable("id") Integer id, ModelMap model) {
                model.addAttribute("trainer", this.trainersService.getTrainerById(id));
		model.addAttribute("listOfTrainers",this.trainersService.getAllTrainers());
            
                return "trainersDetails";
	}
 
	@RequestMapping(value = "/deleteTrainer/{id}", method = RequestMethod.GET)
	public String deleteTrainer(@PathVariable("id") Integer id) {
		trainersService.deleteTrainer(id);
		return "redirect:/getAllTrainers";
 
	}	
}
 
    
    

