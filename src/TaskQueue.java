import java.util.Queue;

public class TaskQueue{
    Queue<Task> tasks;
    void addSmth(String name,int priority) throws wrongPriority {
        try {
            if (priority > 5) throw new wrongPriority("priority cant be more than 5");


            Task task = new Task();
            task.setPriority(priority);
            task.setName(name);
            tasks.add(task);
        } catch (wrongPriority e) {
            throw new RuntimeException(e);
        }
    }

}
class Task {
    private String name;
    private int priority;
//    Task(String namee,int prority){
//        setName(namee);
//        setPriority(prority);
//    }
    public void setPriority(int priority) {this.priority = priority;}

    public void setName(String name) {this.name = name;}
}
class wrongPriority extends Exception{
    private String cause;
    private String msg;
    public String getString(){return msg;}
    public static String getCause(String cause) {
        return cause;
    }
    public wrongPriority(String msg){

    }

    wrongPriority(String cause){
        this.cause = cause;
        Exception exception = new Exception(wrongPriority.getCause(cause));
    }
}
