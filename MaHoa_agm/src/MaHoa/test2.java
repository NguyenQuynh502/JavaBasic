package MaHoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test2 extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private final String url = "jdbc:mysql://localhost:3306/SinhVien";
    private final String usernameDB = "root";
    private final String passwordDB = "Quynh12345";

    public test2() {
        setTitle("Đăng ký");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Đăng ký");
        registerButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(registerButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Đăng ký")) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String hashedPassword = hashSHA1(password);

            try {
                Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);

                String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, hashedPassword);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!\nTên đăng nhập: " + username);
                }

                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Đăng ký thất bại. Lỗi: " + ex.getMessage());
            }
        }
    }

    private String hashSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
public static void main(String[] args) {
        SwingUtilities.invokeLater(test2::new);
    }
}