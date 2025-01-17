import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    Queue<Task> tasks;

    public TaskQueue() {
        tasks = new LinkedList<>(); // Инициализация очереди
    }

    void addSmth(String name, int priority) throws wrongPriority {
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

    // Метод для обновления приоритета задачи
    public void updatePriority(String name, int newPriority) throws wrongPriority {
        if (newPriority > 5) throw new wrongPriority("priority cant be more than 5");

        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setPriority(newPriority);
                return; // Завершаем метод, если задача найдена и приоритет обновлен
            }
        }

        // Если задача с таким именем не найдена, можно выбросить исключение или сделать что-то другое
        throw new RuntimeException("Task not found: " + name);
    }

    // Метод для отображения всех задач в очереди
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the queue.");
            return;
        }

        System.out.println("Tasks in the queue:");
        for (Task task : tasks) {
            System.out.println("Task Name: " + task.getName() + ", Priority: " + task.getPriority());
        }
    }
}

class Task {
    private String name;
    private int priority;

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}

class wrongPriority extends Exception {
    private String cause;

    public String getString() {
        return cause;
    }

    public static String getCause(String cause) {
        return cause;
    }

    wrongPriority(String cause) {
        this.cause = cause;
    }
}