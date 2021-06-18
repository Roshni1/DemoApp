package main.Services;

import main.model.vehicle;
import org.springframework.stereotype.Service;


@Service
public class vehicleService {

   public vehicle getvehicle()
   {
       return (new vehicle("1","test1","test2"));
   }
}
