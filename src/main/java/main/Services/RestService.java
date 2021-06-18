package main.Services;

import main.model.Rest;
import main.repository.Dao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestService {

    private static Dao dao = new Dao();

    public List<Rest> getRList() {

        try
        {
            return dao.getallrest();
        }
        catch (Exception e)
        {
            System.out.println("error1");
            return null;
        }
    }

    public Rest getrest(String id) {
        try {
            return dao.getrestapi(id);

        } catch (Exception e) {
            System.out.println("error");
            return null;

        }
    }

    public void addRest(Rest rest) {
        try {
            dao.add(rest);
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public void updateRest(Rest rst, String id) {

        try {
            dao.updateapi(rst, id);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void deleteRest(String id) {

        try {
            dao.deleteapi(id);
        } catch (Exception e) {
            System.out.println("error");
        }

    }
}

