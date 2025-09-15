package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherAppUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WeatherAppUI().createUI();
        });
    }

    public void createUI() {
        JFrame frame = new JFrame("Weather Application");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel with padding
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(230, 240, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // City Label
        JLabel cityLabel = new JLabel("Enter City:");
        cityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(cityLabel, gbc);

        // City Text Field
        JTextField cityField = new JTextField(20);
        cityField.setFont(new Font("Arial", Font.PLAIN, 14));
        cityField.setToolTipText("Enter city name here");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(cityField, gbc);

        // Get Weather Button
        JButton getWeatherButton = new JButton("Get Weather");
        getWeatherButton.setFont(new Font("Arial", Font.BOLD, 14));
        getWeatherButton.setBackground(new Color(70, 130, 180));
        getWeatherButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(getWeatherButton, gbc);

        // Result Area
        JTextArea resultArea = new JTextArea(8, 30);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        frame.add(panel);
        frame.setVisible(true);

        // Button Action
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    String result = WeatherApp.getWeatherData(city); // call your backend
                    resultArea.setText(result);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a city name.");
                }
            }
        });
    }
}
