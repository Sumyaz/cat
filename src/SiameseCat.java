import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class SiameseCat extends Cat {
    // Additional attributes specific to SiameseCat
    private String eyeColor;
    public SiameseCat(String name, String color, String eyeColor) {
        super(name, "Siamese", color);
        this.eyeColor = eyeColor;
    }
    public String getInfo() {
        return super.getInfo() + ", Eye Color: " + eyeColor;
    }
}