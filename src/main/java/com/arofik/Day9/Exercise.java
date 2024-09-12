package com.arofik.Day9;

import java.util.*;

class User {
    private String username;
    private String password;
    private List<Task> tasks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.tasks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}

class Task {
    private UUID id;
    private String description;

    public Task(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

class ToDoListApp {
    private Map<String, User> users;
    private User currentUser;
    private Scanner scanner;

    public ToDoListApp() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("\n=== Menu Login ===");
        System.out.println("1. Daftar");
        System.out.println("2. Masuk");
        System.out.println("3. Keluar");
        System.out.print("Pilih opsi (1-3): ");

        int choice = getIntInput();
        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("Terima kasih telah menggunakan aplikasi To-Do List.");
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    private void register() {
        System.out.print("Masukkan username baru: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username sudah digunakan. Silakan coba username lain.");
            return;
        }
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        User newUser = new User(username, password);
        users.put(username, newUser);
        System.out.println("Akun berhasil dibuat.");
    }

    private void login() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Login berhasil. Selamat datang, " + username + "!");
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
        }
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Tugas");
            System.out.println("3. Hapus Tugas");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    logout();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void addTask() {
        System.out.print("Masukkan deskripsi tugas: ");
        String description = scanner.nextLine();
        Task newTask = new Task(description);
        currentUser.addTask(newTask);
        System.out.println("Tugas berhasil ditambahkan.");
    }

    private void viewTasks() {
        List<Task> tasks = currentUser.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Tidak ada tugas dalam daftar.");
        } else {
            System.out.println("Daftar Tugas:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " (ID: " + task.getId() + ")");
            }
        }
    }

    private void deleteTask() {
        viewTasks();
        if (currentUser.getTasks().isEmpty()) {
            return;
        }
        System.out.print("Masukkan nomor tugas yang ingin dihapus: ");
        int taskNumber = getIntInput();
        if (taskNumber < 1 || taskNumber > currentUser.getTasks().size()) {
            System.out.println("Nomor tugas tidak valid.");
            return;
        }
        Task taskToRemove = currentUser.getTasks().get(taskNumber - 1);
        currentUser.removeTask(taskToRemove);
        System.out.println("Tugas berhasil dihapus.");
    }

    private void logout() {
        currentUser = null;
        System.out.println("Anda telah keluar dari akun.");
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }
    }

    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        app.start();
    }
}