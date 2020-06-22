package at.cc.jku.task;

public class TaskVO {

    private int id;
    private String name;
    private boolean done;


    public TaskVO(int id, String name, boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
