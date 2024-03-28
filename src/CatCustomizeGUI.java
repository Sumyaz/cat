import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
public class CatCustomizeGUI {
    private JFrame frame;
    private JComboBox<String> catTypeComboBox;
    private JTextField nameField, colorField;
    private JComboBox<String> eyeColorComboBox;
    private JComboBox<String> furTypeComboBox;
    private JButton customizeButton, saveButton;
    private JTextArea catInfoTextArea;
    private JPanel imagePanel;
    private HashMap<String, ImageIcon> imageMap;
    private ArrayList<Cat> currentCats;
    private UserAccount userAccount;
    public CatCustomizeGUI() {
        frame = new JFrame("Cat Customization");
        frame.setLayout(null);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(350, 20, 80, 25);
        frame.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(390, 20, 200, 25);
        frame.add(nameField);
       colorField = new JTextField();
        colorField.setBounds(1, 5, 2, 2);
       frame.add(colorField);
        JLabel catTypeLabel = new JLabel("Cat Type:");
        catTypeLabel.setBounds(335, 50, 80, 25);
        frame.add(catTypeLabel);
        String[] catTypes = {"Siamese", "Persian"};
        catTypeComboBox = new JComboBox<>(catTypes);
        catTypeComboBox.setBounds(390, 50, 200, 25);
        frame.add(catTypeComboBox);
        JLabel eyeColorLabel = new JLabel("Eye Color:");
        eyeColorLabel.setBounds(332, 80, 80, 25);
        frame.add(eyeColorLabel);
        String[] eyeColors = {"Blue", "Green", "Brown"};
        eyeColorComboBox = new JComboBox<>(eyeColors);
        eyeColorComboBox.setBounds(390, 80, 200, 25);
        frame.add(eyeColorComboBox);
        customizeButton = new JButton("Customize Cat");
        customizeButton.setBounds(300, 110, 150, 25);
        customizeButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                 customizeCat();
            }
       });
        frame.add(customizeButton);
        saveButton = new JButton("Save Cat");
        saveButton.setBounds(490, 110, 150, 25);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCat();
            }
        });
        frame.add(saveButton);
        catInfoTextArea = new JTextArea();
        catInfoTextArea.setBounds(200, 160, 550, 400);
        frame.add(catInfoTextArea);
        imagePanel = new JPanel();
        imagePanel.setBounds(200, 200, 600, 500);
        imagePanel.setLayout(new GridLayout(1, 2));
        frame.add(imagePanel);
        loadPics();
        frame.setVisible(true);
        userAccount = new UserAccount();
        currentCats = new ArrayList<>();
    }
    private void loadPics() {
        imageMap = new HashMap<>();
        imageMap.put("Siamese_Blue", new ImageIcon("C:\\Users\\sumya\\Downloads\\IMG_1072.jpg"));
        imageMap.put("Siamese_Green", new ImageIcon("siamese_green.jpg"));
        imageMap.put("Siamese_Brown", new ImageIcon("siamese_brown.jpg"));
        imageMap.put("Persian_Blue", new ImageIcon("persian_blue.jpg"));
        imageMap.put("Persian_Green", new ImageIcon("persian_green.jpg"));
        imageMap.put("Persian_Brown", new ImageIcon("C:\\Users\\sumya\\Downloads\\IMG_1078.jpg"));
    }
    private void customizeCat() {
        String name = nameField.getText();
        String color = colorField.getText();
        String catType = (String) catTypeComboBox.getSelectedItem();
        String eyeColor = (String) eyeColorComboBox.getSelectedItem();
        Cat cat;
        if (catType.equals("Siamese")) {
            cat = new SiameseCat(name, color, eyeColor);
        }
        else {
            String furType = JOptionPane.showInputDialog(frame, "Enter Fur Type:");
            cat = new PersianCat(name, color, furType);
        }
        currentCats.add(cat);
        catInfoTextArea.append(cat.getInfo() + "\n");
        updateImages(catType, eyeColor);
    }
    private void updateImages(String catType, String eyeColor) {
        imagePanel.removeAll();
        imagePanel.revalidate();
        imagePanel.repaint();
        String imageName = catType + "_" + eyeColor;
        ImageIcon imageIcon = imageMap.get(imageName);
        if (imageIcon != null) {
            JLabel imageLabel = new JLabel(imageIcon);
            imagePanel.add(imageLabel);
        } else {
            JLabel noImageLabel = new JLabel("No image available :(");
            imagePanel.add(noImageLabel);
        }

      //  String imageName = catType + "_" + eyeColor;
      //  ImageIcon imageIcon = imageMap.get(imageName);
       //     JLabel imageLabel = new JLabel(imageIcon);
      //      imagePanel.add(imageLabel);
       // imagePanel.setBounds(350, 200, 350, 500);
    }
    private void saveCat() {
        userAccount.addCat(new ArrayList<>(currentCats));
        currentCats.clear();
        catInfoTextArea.setText("");
    }
    public static void main(String[] args) {
        new CatCustomizeGUI();
    }
}