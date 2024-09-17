package day10;

public abstract class LibraryMaterial {
    protected String title;
    protected int availableCopies;
    protected int totalCopies;

    public LibraryMaterial(String title, int totalCopies) {
        this.title = title;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    // Method to borrow material
    public boolean borrowMaterial() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        } else {
            return false;
        }
    }

    // Method to return material
    public void returnMaterial() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    // Abstract method to show material details
    public abstract void showDetails();

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }
}