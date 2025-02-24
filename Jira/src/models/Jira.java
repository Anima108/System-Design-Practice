package models;
import Datatype.Status;
import Factory.SprintFactory;
import Factory.TaskFactory;
import Factory.UserFactory;

import java.util.*;

public class Jira {
    List<Sprint>  sprints;
    List<Task> tasks;
    List<Integer> users;

    private Jira(){
        this.sprints = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static Jira getInstance(){
        return new Jira();
    }

    public void createUser(int id, String name){
        if(users.contains(id)){
            System.out.println("User already exists");
            return;
        }
        User user = UserFactory.getUser(id, name);
    }

    public void deleteUser(Integer id){
        users.remove(id);
    }

    public void createFeature(int id, String title){
       Task tsk = TaskFactory.getFeature(id,title);
       tasks.add(tsk);
    }

    public void createDefect(int id, String title){
        Task tsk = TaskFactory.getDefect(id,title);
        tasks.add(tsk);
    }

    public void createStory(int id, String title){
        Task tsk = TaskFactory.getStory(id,title);
        tasks.add(tsk);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }

    public void printTaskDetails(Task task){
        task.getDetails();
    }

    public void printSprintDetails(int sprint_id){
        Sprint sp = null;
        for(Sprint spr : sprints){
            if(spr.getSprint_id() == sprint_id){
                sp=spr;
                break;
            }
        }
        sp.printDetails();
    }

    public void createSprint(int id){
        Sprint sp = SprintFactory.getSprintFactory(id);
        sprints.add(sp);
    }

    public void addTask(int sprintID, int taskID){
        Task task = null;
        Sprint sp = null;
        for(Task tsk : tasks){
            if(tsk.getTask_id() == taskID)
            {    task = tsk;
                break;
            }
        }
        for(Sprint spr : sprints){
            if(spr.getSprint_id() == sprintID){
                sp=spr;
                break;
            }
        }
        if(sp == null || task == null){
            System.out.println("invalid input");
            return;
        }
        sp.addTask(task);
    }

    public void removeTask(int sprintID, int taskID){
        Task task = null;
        Sprint sp = null;
        for(Task tsk : tasks){
            if(tsk.getTask_id() == taskID)
            {    task = tsk;
                break;
            }
        }
        for(Sprint spr : sprints){
            if(spr.getSprint_id() == sprintID){
                sp=spr;
                break;
            }
        }
        if(sp == null || task == null){
            System.out.println("invalid input");
            return;
        }
        sp.deleteTask(task);
    }

  public void updateTaskStatus(int taskID, Status status){
      Task task = null;
      for(Task tsk : tasks){
          if(tsk.getTask_id() == taskID)
          {    task = tsk;
              break;
          }
      }
      if(task == null){
          System.out.println("Task doesn't exist");
          return;
      }
      task.setStatus(status);
      System.out.println("Task Status updated to :"+ status.name());
  }

  public void addSubtaskToStory(Task subtsk, int storyid ){
      Task task = null;
      for(Task tsk : tasks){
          if(tsk.getTask_id() == storyid)
          {    task = tsk;
              break;
          }
      }
      if(task == null){
          System.out.println("Task doesn't exist");
          return;
      }
      task.addSubtask(subtsk);
  }


}