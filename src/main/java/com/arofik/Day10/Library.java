package com.arofik.Day10;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryMaterial> materials;

    public Library() {
        this.materials = new ArrayList<>();
    }

    // Add material to the library
    public void addMaterial(LibraryMaterial material) {
        materials.add(material);
    }

    // Borrow material
    public void borrowMaterial(String title) {
        LibraryMaterial material = findMaterial(title);
        if (material != null) {
            if (material.borrowMaterial()) {
                System.out.println("You have borrowed: " + material.getTitle());
            } else {
                System.out.println("Sorry, no copies of " + material.getTitle() + " are available.");
            }
        } else {
            System.out.println("Material not found.");
        }
    }

    // Return material
    public void returnMaterial(String title) {
        LibraryMaterial material = findMaterial(title);
        if (material != null) {
            material.returnMaterial();
            System.out.println("You have returned: " + material.getTitle());
        } else {
            System.out.println("Material not found.");
        }
    }

    // Display all materials in the library
    public void showAllMaterials() {
        System.out.println("\nLibrary Collection:");
        for (LibraryMaterial material : materials) {
            material.showDetails();
        }
    }

    // Helper method to find a material by title
    private LibraryMaterial findMaterial(String title) {
        for (LibraryMaterial material : materials) {
            if (material.getTitle().equalsIgnoreCase(title)) {
                return material;
            }
        }
        return null;
    }
}