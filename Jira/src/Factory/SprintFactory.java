package Factory;

import models.Sprint;

public class SprintFactory {

    public static Sprint getSprintFactory(int id){
        return new Sprint(id);
    }


}
