package View;

import Controller.TileInfoListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TileInfoPanel extends JPanel {

    private MainFrame parentFrame;
    private JTextField capacityTextField;
    private JTextField availabilityTextField;
    private JTextField addressTextField;
    private JTextField zipCodeTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JTextField websiteTextField;
    private JTextField cityTextField;
    private JTextField districtTextField;
    private JTextField ratingTextField;
    private JTextField pollutionLevelTextField;
    private JComboBox districts;

    private int selectedTileIndex;

    public TileInfoPanel(MainFrame mainFrame) {
        this.parentFrame = mainFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.selectedTileIndex = -1;

        JLabel capacity = new JLabel("Capacity:", JLabel.TRAILING);
        JLabel availability = new JLabel("Availability:", JLabel.TRAILING);
        JLabel address = new JLabel("Address:", JLabel.TRAILING);
        JLabel zipCode = new JLabel("ZipCode:", JLabel.TRAILING);
        JLabel phone = new JLabel("Phone:", JLabel.TRAILING);
        JLabel email = new JLabel("Email:", JLabel.TRAILING);
        JLabel website = new JLabel("Website:", JLabel.TRAILING);
        JLabel district = new JLabel("District:", JLabel.TRAILING);
        JLabel city = new JLabel("City:", JLabel.TRAILING);
        JLabel rating = new JLabel("Rating:", JLabel.TRAILING);
        JLabel pollutionLevel = new JLabel("Pollution level:", JLabel.TRAILING);

        capacityTextField = new JTextField(10);
        availabilityTextField = new JTextField(10);
        addressTextField = new JTextField(10);
        zipCodeTextField = new JTextField(10);
        phoneTextField = new JTextField(10);
        emailTextField = new JTextField(10);
        websiteTextField = new JTextField(10);
        cityTextField = new JTextField(10);
        districtTextField = new JTextField(10);
        ratingTextField = new JTextField(10);
        pollutionLevelTextField = new JTextField(10);

        cityTextField.setEditable(false);
        ratingTextField.setEditable(false);
        pollutionLevelTextField.setEditable(false);

        this.add(pollutionLevel);
        pollutionLevel.setLabelFor(pollutionLevelTextField);
        this.add(pollutionLevelTextField);

        this.add(rating);
        rating.setLabelFor(ratingTextField);
        this.add(ratingTextField);

        this.add(city);
        city.setLabelFor(cityTextField);
        this.add(cityTextField);

        this.add(district);
        district.setLabelFor(districtTextField);
        this.add(districtTextField);

        this.add(address);
        address.setLabelFor(addressTextField);
        this.add(addressTextField);

        this.add(zipCode);
        zipCode.setLabelFor(zipCodeTextField);
        this.add(zipCodeTextField);

        this.add(capacity);
        capacity.setLabelFor(capacityTextField);
        this.add(capacityTextField);

        this.add(availability);
        availability.setLabelFor(availabilityTextField);
        this.add(availabilityTextField);

        this.add(phone);
        phone.setLabelFor(phoneTextField);
        this.add(phoneTextField);

        this.add(email);
        email.setLabelFor(emailTextField);
        this.add(emailTextField);

        this.add(website);
        website.setLabelFor(websiteTextField);
        this.add(websiteTextField);

        JButton addInfoButton = new JButton("Add info");
        addInfoButton.addActionListener(new TileInfoListener(this));
        this.add(addInfoButton);
    }

    public String getAddress(){
        return this.addressTextField.getText();
    }

    public String getZipCode(){
        return this.zipCodeTextField.getText();
    }

    public String getEmail(){
        return this.emailTextField.getText();
    }

    public String getWebsite(){
        return this.websiteTextField.getText();
    }

    public String getPhone(){
        return this.phoneTextField.getText();
    }

    public String getCapacity(){
        return this.capacityTextField.getText();
    }

    public String getAvailability(){
        return this.availabilityTextField.getText();
    }

    public String getDistrict(){ return this.districtTextField.getText(); }


    public void setDistrict(String district){
        this.districtTextField.setText(district);
        this.districtTextField.repaint();
    }

    public void setCity(String city){
        this.cityTextField.setText(city);
        this.cityTextField.repaint();
    }

    public void setCapacity(String capacity){
        this.capacityTextField.setText(capacity);
        this.capacityTextField.repaint();
    }

    public void setAvailability(String availability){
        this.availabilityTextField.setText(availability);
        this.availabilityTextField.repaint();
    }

    public void setAddress(String address){
        this.addressTextField.setText(address);
        this.addressTextField.repaint();
    }

    public void setZipCode(String zipCode){
        this.zipCodeTextField.setText(zipCode);
        this.zipCodeTextField.repaint();
    }

    public void setPhone(String phone){
        this.phoneTextField.setText(phone);
        this.phoneTextField.repaint();
    }

    public void setWebsite(String website){
        this.websiteTextField.setText(website);
        this.websiteTextField.repaint();
    }

    public void setPollutionLevel(String pollutionLevel){
        this.pollutionLevelTextField.setText(pollutionLevel);
        this.pollutionLevelTextField.repaint();
    }

    public void setRating(String rating){
        this.ratingTextField.setText(rating);
        this.ratingTextField.repaint();
    }

    public void setEmail(String email){
        this.emailTextField.setText(email);
        this.emailTextField.repaint();
    }

    public void setSelectedTileIndex(int index){
        this.selectedTileIndex = index;
    }

    public int getSelectedTileIndex(){
        return this.selectedTileIndex;
    }

    public MainFrame getParentFrame(){
        return this.parentFrame;
    }
}
