import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class PersianCat extends Cat {
    private String furType;
    public PersianCat(String name, String color, String furType) {
        super(name, "Persian", color);
        this.furType = furType;
    }
    public String getInfo() {
        return super.getInfo() + ", Fur Type: " + furType;
    }
}