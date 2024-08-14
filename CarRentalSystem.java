import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CarRentalSystem {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JFrame frame;

    private JPanel startPage;
    private JPanel addUserPanel;
    private JLabel addUserTitleLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JTextField nameTextField;
    private JTextField addressTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JButton addUserNextButton;

    private JPanel selectCarPanel;
    private JLabel selectCarTitleLabel;
    private JRadioButton civicRadioButton;
    private JRadioButton mehranRadioButton;
    private JRadioButton corollaRadioButton;
    private JRadioButton audiRadioButton;
    private JRadioButton altoRadioButton;
    private ButtonGroup carButtonGroup;
    private JButton selectCarNextButton;

    private JPanel daysForRentPanel;
    private JLabel daysForRentTitleLabel;
    private JLabel daysLabel;
    private JTextField daysTextField;
    private JButton calculateRentButton;
    private JLabel rentResultLabel;
    private JButton daysForRentNextButton;


    private JPanel receiptPanel;
    private JLabel receiptTitleLabel;
    private JTextArea receiptTextArea;
    private JButton receiptFinishButton;
    private JButton receiptPrintButton;

    public CarRentalSystem() {
        // Set up JFrame
        frame = new JFrame("Car Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Set up CardLayout and main panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add pages to card panel
        startPage = createStartPage();
        addUserPanel = createAddUserPanel();
        selectCarPanel = createSelectCarPanel();
        daysForRentPanel = createDaysForRentPanel();
        receiptPanel = createReceiptPanel();

        cardPanel.add(startPage, "StartPage");
        cardPanel.add(addUserPanel, "AddUser");
        cardPanel.add(selectCarPanel, "SelectCar");
        cardPanel.add(daysForRentPanel, "DaysForRent");
        cardPanel.add(receiptPanel, "Receipt");

        // Set up main frame
        frame.setLayout(new BorderLayout());
        frame.add(cardPanel, BorderLayout.CENTER);

        // Initially show the start page
        cardLayout.show(cardPanel, "StartPage");

        // Make the frame visible
        frame.setVisible(true);
    }

    private JPanel createStartPage() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel headingLabel = new JLabel("Car Rental System", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JButton addUserButton = new JButton("Add User");
        JButton exitButton = new JButton("Exit");
    
        panel.add(headingLabel);
        panel.add(addUserButton);
        panel.add(exitButton);
    
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AddUser");
            }
        });
    
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    
        return panel;
    }
    
    private JPanel createAddUserPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));
    
        addUserTitleLabel = new JLabel("Add User");
        addUserTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        addUserTitleLabel.setHorizontalAlignment(JLabel.CENTER);
    
        nameLabel = new JLabel("Name:");
        addressLabel = new JLabel("Address:");
        phoneLabel = new JLabel("Phone No:");
        emailLabel = new JLabel("Email:");
    
        nameTextField = new JTextField();
        addressTextField = new JTextField();
        phoneTextField = new JTextField();
        emailTextField = new JTextField();
    
        addUserNextButton = new JButton("Next");
    
        panel.add(addUserTitleLabel);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(addressLabel);
        panel.add(addressTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(addUserNextButton);
    
        addUserNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "SelectCar");
            }
        });
    
        return panel;
    }
    
    private JPanel createSelectCarPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 1));
    
        selectCarTitleLabel = new JLabel("Select Car");
        selectCarTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        selectCarTitleLabel.setHorizontalAlignment(JLabel.CENTER);
    
        civicRadioButton = new JRadioButton("Civic");
        mehranRadioButton = new JRadioButton("Mehran");
        corollaRadioButton = new JRadioButton("Corolla");
        audiRadioButton = new JRadioButton("Audi");
        altoRadioButton = new JRadioButton("Alto");
    
        carButtonGroup = new ButtonGroup();
        carButtonGroup.add(civicRadioButton);
        carButtonGroup.add(mehranRadioButton);
        carButtonGroup.add(corollaRadioButton);
        carButtonGroup.add(audiRadioButton);
        carButtonGroup.add(altoRadioButton);
    
        selectCarNextButton = new JButton("Next");
    
        panel.add(selectCarTitleLabel);
        panel.add(civicRadioButton);
        panel.add(mehranRadioButton);
        panel.add(corollaRadioButton);
        panel.add(audiRadioButton);
        panel.add(altoRadioButton);
        panel.add(selectCarNextButton);
    
        selectCarNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "DaysForRent");
            }
        });
    
        return panel;
    }

    private JPanel createDaysForRentPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 1));
    
        daysForRentTitleLabel = new JLabel("Days for Rent");
        daysForRentTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        daysForRentTitleLabel.setHorizontalAlignment(JLabel.CENTER);
    
        daysLabel = new JLabel("Days:");
        daysTextField = new JTextField();
        calculateRentButton = new JButton("Calculate Rent");
        rentResultLabel = new JLabel("");
        daysForRentNextButton = new JButton("Next");
    
        panel.add(daysForRentTitleLabel);
        panel.add(daysLabel);
        panel.add(daysTextField);
        panel.add(calculateRentButton);
        panel.add(rentResultLabel);
        panel.add(daysForRentNextButton);
    
        calculateRentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int days = Integer.parseInt(daysTextField.getText());
                int rent = 0;
                if (civicRadioButton.isSelected()) {
                    rent = days * 2000; // changed price to 2000 per day
                } else if (mehranRadioButton.isSelected()) {
                    rent = days * 1500; // changed price to 1500 per day
                } else if (corollaRadioButton.isSelected()) {
                    rent = days * 2500; // changed price to 2500 per day
                } else if (audiRadioButton.isSelected()) {
                    rent = days * 4000; // changed price to 4000 per day
                } else if (altoRadioButton.isSelected()) {
                    rent = days * 1200; // changed price to 1200 per day
                }
                rentResultLabel.setText("Rent: " + rent + " rupees");
            }
        });
    
        daysForRentNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Receipt");
                displayReceipt();
            }
        });
    
        return panel;
    }


    private JPanel createReceiptPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        receiptTitleLabel = new JLabel("Receipt");
        receiptTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        receiptTitleLabel.setHorizontalAlignment(JLabel.CENTER);

        receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);

        receiptFinishButton = new JButton("Finish");
        receiptPrintButton = new JButton("Print");

        panel.add(receiptTitleLabel, BorderLayout.NORTH);
        panel.add(receiptTextArea, BorderLayout.CENTER);
        panel.add(receiptFinishButton, BorderLayout.SOUTH);
        panel.add(receiptPrintButton, BorderLayout.SOUTH);

        receiptFinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        receiptPrintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\Asif computer\\Documents\\receipt.txt");
                    writer.write(receiptTextArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Receipt saved ");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        return panel;
    }

    private void displayReceipt() {
        String receipt = "Car Rental Receipt\n";
        receipt += "-------------------\n";
        receipt += "Name: " + nameTextField.getText() + "\n";
        receipt += "Address: " + addressTextField.getText() + "\n";
        receipt += "Phone No: " + phoneTextField.getText() + "\n";
        receipt += "Email: " + emailTextField.getText() + "\n";
        receipt += "Car: " + getSelectedCar() + "\n";
        receipt += "Days: " + daysTextField.getText() + "\n";
        receipt += "Rent: " + rentResultLabel.getText() + "\n";
        receiptTextArea.setText(receipt);
    }

    private String getSelectedCar() {
        if (civicRadioButton.isSelected()) {
            return "Civic";
        } else if (mehranRadioButton.isSelected()) {
            return "Mehran";
        } else if (corollaRadioButton.isSelected()) {
            return "Corolla";
        } else if (audiRadioButton.isSelected()) {
            return "Audi";
        } else if (altoRadioButton.isSelected()) {
            return "Alto";
        } else {
            return "No car selected";
        }
    }

    public static void main(String[] args) {
        new CarRentalSystem();
    }
}
