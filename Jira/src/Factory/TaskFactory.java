package Factory;

import Datatype.Type;
import models.Task;

public class TaskFactory {

    public static Task getFeature(int id, String title){
        return new Task(id, Type.FEATURE,title);
    }

    public static Task getDefect(int id, String title){
        return new Task(id, Type.DEFECT,title);
    }

    public static Task getStory(int id, String title){
        return new Task(id, Type.STORY,title);
    }


}
