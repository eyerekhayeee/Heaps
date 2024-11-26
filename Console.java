import java.util.PriorityQueue;
import java.util.Scanner;

class Task implements Comparable<Task> {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task: " + description + " (Priority: " + priority + ")";
    }
}

public class TaskPrioritizer {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Task Prioritizer Application ===");
        int choice;
        do {
            System.out.println("\nOptions:");
            System.out.println("1. Add a Task");
            System.out.println("2. View Next Task");
            System.out.println("3. Complete Next Task");
            System.out.println("4. Display All Tasks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (1 = highest, higher number = lower priority): ");
                    int priority = scanner.nextInt();
                    taskQueue.add(new Task(description, priority));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("Next task: " + taskQueue.peek());
                    }
                    break;

                case 3:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("Completing task: " + taskQueue.poll());
                    }
                    break;

                case 4:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("All tasks:");
                        for (Task task : taskQueue) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
