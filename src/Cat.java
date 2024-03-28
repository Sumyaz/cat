import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Cat {
    public String name;
    public String breed;
    public String color;

    public Cat(String name, String breed, String color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    // Common method for all cats
    public String getInfo() {
        return "Name: " + name + ", Breed: " + breed + ", Color: " + color;
    }
}