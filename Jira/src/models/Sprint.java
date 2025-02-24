package models;

import java.util.*;
import java.util.logging.Logger;

public class Sprint {

    public Sprint(int id){
        this.tasks = new ArrayList<>();
        this.sprint_id = id;
        this.users= new HashMap<>();
    }
    List<Task> tasks;
    int sprint_id;
    HashMap<User,List<Task>> users;

    public void addTask(Task tsk){
        if(tasks.contains(tsk)){
            System.out.println("This task is already part of this sprint");
        }
        tasks.add(tsk);
//        List<Task> tsks = users.get(tsk.assignee);
//        tsks.add(tsk);
//        users.put(tsk.assignee,tsks);
    }

    public void deleteTask(Task tsk){
        if(tasks.contains(tsk)){
            tasks.remove(tsk);
            List<Task> tsks = users.get(tsk.assignee);
            tsks.remove(tsk);
            if(tsks.size() == 0)
                users.remove(tsk.assignee);
            else{
            users.put(tsk.assignee,tsks);}
        }
        else{
            System.out.println("This Sprint doesn't contain this task");
        }
    }

    public void printDetails(){
        for(Task tsk : tasks){
            System.out.println(tsk.getTitle());
        }
//        for(Map.Entry<User, List<Task>> it : users.entrySet()){
//            System.out.println(it.getKey().getName());
//            System.out.println("Tasks assigned");
//            for(Task task : it.getValue()){
//                System.out.println(task.getTitle());
//            }
//        }
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getSprint_id() {
        return sprint_id;
    }

    public void setSprint_id(int sprint_id) {
        this.sprint_id = sprint_id;
    }

    public HashMap<User, List<Task>> getUsers() {
        return users;
    }

    public void setUsers(HashMap<User, List<Task>> users) {
        this.users = users;
    }
}
