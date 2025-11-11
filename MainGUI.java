/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maingui;

/**
 *
 * @author RC_Student_Lab
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java Swing GUI application for displaying and saving product sales data.
 */
public class MainGUI extends JFrame {
    private JButton loadButton;
    private JButton saveButton;
    private JTextArea textArea;
    private JLabel yearsLabel;
    private ProductSales productSales;

    /**
     * Constructor initializes the GUI components and layout.
     */
    public MainGUI() {
        productSales = new ProductSales();  // Create the product sales processing instance

        setTitle("Product Sales Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center on screen

        // Initialize GUI components
        loadButton = new JButton("Load Product Data");
        saveButton = new JButton("Save Product Data");
        textArea = new JTextArea(8, 30);
        textArea.setEditable(false); // Make text area read-only for display
        yearsLabel = new JLabel("Years Processed: 0"); // Initially zero

        // Panel to hold buttons vertically
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);

        // Set the layout for the frame
        setLayout(new BorderLayout(10, 10));
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(yearsLabel, BorderLayout.SOUTH);

        // Setup application menus
        setupMenu();

        // Attach event handlers to buttons
        loadButton.addActionListener(e -> loadProductData());
        saveButton.addActionListener(e -> saveProductData());
    }
    /**
     * Setup the menu bar with required menus and menu items.
     */
    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();

        // File menu with Exit option to close the app
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Tools menu with Load, Save and Clear options
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        loadItem.addActionListener(e -> loadProductData());

        JMenuItem saveItem = new JMenuItem("Save Product Data");
        saveItem.addActionListener(e -> saveProductData());

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }
    /**
     * Loads the product data from ProductSales and updates the GUI display.
     */
    private void loadProductData() {
        // Get required values from the product sales processor
        int totalSales = productSales.GetTotalSales();
        double averageSales = productSales.GetAverageSales();
        int salesOver = productSales.GetSalesOverLimit();
        int salesUnder = productSales.GetSalesUnderLimit();
        int yearsProcessed = productSales.GetProductsProcessed();

        // Format the display text similar to the screenshot
        StringBuilder displayText = new StringBuilder();
        displayText.append("Total Sales: ").append(totalSales).append("\n");
        displayText.append("Average Sales: ").append((int)averageSales).append("\n");
        displayText.append("Sales over limit: ").append(salesOver).append("\n");
        displayText.append("Sales under limit: ").append(salesUnder).append("\n");

        // Show the report in the text area
        textArea.setText(displayText.toString());

        // Update the label with years processed count
        yearsLabel.setText("Years Processed: " + yearsProcessed);
    }
    /**
     * Saves the current report shown in the text area to a file named data.txt.
     */
    private void saveProductData() {
        try (FileWriter fw = new FileWriter("data.txt")) {
            // Write header and footer to make file format like the screenshot
            fw.write("DATA LOG\n");
            fw.write("******************************\n");
            fw.write(textArea.getText());
            fw.write("******************************\n");

            // Notify user of successful save
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            // Show error if unable to save
            JOptionPane.showMessageDialog(this, "Failed to save data: " + ex.getMessage());
        }
    }
    /**
     * Clears the text area and resets the years processed label.
     */
    private void clearData() {
        textArea.setText("");
        yearsLabel.setText("Years Processed: 0");
    }
    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}

