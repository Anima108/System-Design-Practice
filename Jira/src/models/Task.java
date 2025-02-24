package models;
import Datatype.Status;
import Datatype.Type;

import java.util.*;

public class Task {


    public Task(int id, Type type, String title) {

        this.comments = new ArrayList<>();
        this.task_id = id;
        this.type= type;
        this.subtask = null;
        this.status=Status.OPEN;
        this.title=title;
        if(type == Type.STORY ){
            this.subtask = new ArrayList<>();
        }
    }

        int task_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getSubtask() {
        return subtask;
    }

    public void setSubtask(List<Task> subtask) {
        this.subtask = subtask;
    }

    public void addSubtask(Task tsk){
        if(this.type != Type.STORY){
            System.out.println("invalid operation, you can only add subtask to story");
            return;
        }
        subtask.add(tsk);
    }

    String title;
        String description;
        List<String> comments;
        User assignee;
        User reporter;
        Status status;
        Type type;
        List<Task> subtask;


    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String com){
        comments.add(com);
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void getDetails(){
        System.out.println("TITLE : "+title);
        System.out.println("Description : "+ description);
        System.out.println("Status : "+status.name());
        System.out.println("Assignee : "+assignee.getName());
        System.out.println("Reporter : "+reporter.getName());
    }

}
