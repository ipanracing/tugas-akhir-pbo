package Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class MainClass extends JFrame {
    private JTextField kodeTempatField;
    private JTextField namaTempatField;
    private JTextField kodeJenisField;
    private JTextField gambarField;
    private JTextField kodeAgamaField;
    private JTextField longitudeField;
    private JTextField latitudeField;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private Connection connection;

    public MainClass() {
        // Setup form
        setTitle("CRUD Tempat");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        connectDatabase();

        createButton.addActionListener((ActionEvent e) -> {
            createTempat();
            loadDataToTable();
        });

        readButton.addActionListener((ActionEvent e) -> {
            loadDataToTable();
        });

        updateButton.addActionListener((ActionEvent e) -> {
            updateTempat();
            loadDataToTable();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            deleteTempat();
            loadDataToTable();
        });

        loadDataToTable();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel kodeTempatLabel = new JLabel("Kode Tempat:");
        kodeTempatLabel.setBounds(10, 20, 80, 25);
        panel.add(kodeTempatLabel);

        kodeTempatField = new JTextField(20);
        kodeTempatField.setBounds(150, 20, 165, 25);
        panel.add(kodeTempatField);

        JLabel namaTempatLabel = new JLabel("Nama Tempat:");
        namaTempatLabel.setBounds(10, 50, 80, 25);
        panel.add(namaTempatLabel);

        namaTempatField = new JTextField(20);
        namaTempatField.setBounds(150, 50, 165, 25);
        panel.add(namaTempatField);

        JLabel kodeJenisLabel = new JLabel("Kode Jenis:");
        kodeJenisLabel.setBounds(10, 80, 80, 25);
        panel.add(kodeJenisLabel);

        kodeJenisField = new JTextField(20);
        kodeJenisField.setBounds(150, 80, 165, 25);
        panel.add(kodeJenisField);

        JLabel gambarLabel = new JLabel("Gambar:");
        gambarLabel.setBounds(10, 110, 80, 25);
        panel.add(gambarLabel);

        gambarField = new JTextField(20);
        gambarField.setBounds(150, 110, 165, 25);
        panel.add(gambarField);

        JLabel kodeAgamaLabel = new JLabel("Kode Agama:");
        kodeAgamaLabel.setBounds(10, 140, 80, 25);
        panel.add(kodeAgamaLabel);

        kodeAgamaField = new JTextField(20);
        kodeAgamaField.setBounds(150, 140, 165, 25);
        panel.add(kodeAgamaField);

        JLabel longitudeLabel = new JLabel("Longitude:");
        longitudeLabel.setBounds(10, 170, 80, 25);
        panel.add(longitudeLabel);

        longitudeField = new JTextField(20);
        longitudeField.setBounds(150, 170, 165, 25);
        panel.add(longitudeField);

        JLabel latitudeLabel = new JLabel("Latitude:");
        latitudeLabel.setBounds(10, 200, 80, 25);
        panel.add(latitudeLabel);

        latitudeField = new JTextField(20);
        latitudeField.setBounds(150, 200, 165, 25);
        panel.add(latitudeField);

        createButton = new JButton("Create");
        createButton.setBounds(10, 230, 80, 25);
        panel.add(createButton);

        readButton = new JButton("Read");
        readButton.setBounds(100, 230, 80, 25);
        panel.add(readButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(190, 230, 80, 25);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(280, 230, 80, 25);
        panel.add(deleteButton);

        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(10, 260, 560, 100);
        panel.add(scrollPane);

        tableModel.addColumn("Kode Tempat");
        tableModel.addColumn("Nama Tempat");
        tableModel.addColumn("Kode Jenis");
        tableModel.addColumn("Gambar");
        tableModel.addColumn("Kode Agama");
        tableModel.addColumn("Longitude");
        tableModel.addColumn("Latitude");
    }

    private void connectDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/tabel pbo 2210020063";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Cannot connect to the database! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTempat() {
        try {
            String query = "INSERT INTO Tempat (kodeTempat, namaTempat, kodeJenis, gambar, kodeAgama, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kodeTempatField.getText());
            preparedStatement.setString(2, namaTempatField.getText());
            preparedStatement.setString(3, kodeJenisField.getText());
            preparedStatement.setString(4, gambarField.getText());
            preparedStatement.setString(5, kodeAgamaField.getText());
            preparedStatement.setString(6, longitudeField.getText());
            preparedStatement.setString(7, latitudeField.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data created successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error creating data! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadDataToTable() {
        try {
            String query = "SELECT * FROM Tempat";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            tableModel.setRowCount(0); // Clear existing data

            while (resultSet.next()) {
                String kodeTempat = resultSet.getString("kodeTempat");
                String namaTempat = resultSet.getString("namaTempat");
                String kodeJenis = resultSet.getString("kodeJenis");
                String gambar = resultSet.getString("gambar");
                String kodeAgama = resultSet.getString("kodeAgama");
                String longitude = resultSet.getString("longitude");
                String latitude = resultSet.getString("latitude");
                tableModel.addRow(new Object[]{kodeTempat, namaTempat, kodeJenis, gambar, kodeAgama, longitude, latitude});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void updateTempat() {
        try {
            String query = "UPDATE Tempat SET namaTempat = ?, kodeJenis = ?, gambar = ?, kodeAgama = ?, longitude = ?, latitude = ? WHERE kodeTempat = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, namaTempatField.getText());
            preparedStatement.setString(2, kodeJenisField.getText());
            preparedStatement.setString(3, gambarField.getText());
            preparedStatement.setString(4, kodeAgamaField.getText());
            preparedStatement.setString(5, longitudeField.getText());
            preparedStatement.setString(6, latitudeField.getText());
            preparedStatement.setString(7, kodeTempatField.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating data! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void deleteTempat() {
        try {
            String query = "DELETE FROM Tempat WHERE kodeTempat = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kodeTempatField.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting data! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }

    private void setString(int i, String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class prepared {

        public prepared() {
        }

        private void executeUpdate() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}