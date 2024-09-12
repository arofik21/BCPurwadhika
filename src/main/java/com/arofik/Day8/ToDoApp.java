package com.arofik.Day9;

import java.util.*;

public class ToDoApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== To-Do List Application ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter desired login: ");
                    String newLogin = scanner.nextLine();
                    System.out.print("Enter desired password: ");
                    String newPassword = scanner.nextLine();
                    userManager.registerUser(newLogin, newPassword);
                    break;
                case 2:
                    System.out.print("Enter login: ");
                    String login = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User user = userManager.loginUser(login, password);
                    if (user != null) {
                        manageTasks(user, scanner);
                    } else {
                        System.out.println("Login failed. Please check your credentials.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageTasks(User user, Scanner scanner) {
        TaskManager taskManager = user.getTaskManager();

        while (true) {
            System.out.println("\n==== Task Management ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Logout");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    taskManager.addTask(taskDescription);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to delete: ");
                    String taskId = scanner.nextLine();
                    taskManager.deleteTask(taskId);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class User {
    private String login;
    private String password;
    private TaskManager taskManager;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.taskManager = new TaskManager();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }
}

class UserManager {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String login, String password) {
        if (users.containsKey(login)) {
            System.out.println("User already exists.");
        } else {
            users.put(login, new User(login, password));
            System.out.println("User registered successfully.");
        }
    }

    public User loginUser(String login, String password) {
        User user = users.get(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}

class Task {
    private String id;
    private String description;

    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description;
    }
}

class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.put(task.getId(), task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks.values()) {
                System.out.println(task);
            }
        }
    }

    public void deleteTask(String taskId) {
        if (tasks.remove(taskId) != null) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
