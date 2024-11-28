
public class Main {
    public static void main(String[] args) {
        try {
            TaskQueue taskQueue = new TaskQueue();
            taskQueue.addSmth("Задача 1", 4);
            taskQueue.displayTasks();
            taskQueue.updatePriority("Задача 1",5);
            taskQueue.displayTasks();
        } catch (wrongPriority e) {
            throw new RuntimeException(e);
        }


    }
    }