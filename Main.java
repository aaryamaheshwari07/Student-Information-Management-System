import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Main extends Frame implements ActionListener {

    // ================= LOGIN =================
    TextField usernameField, passwordField;
    Button loginButton;

    // ================= DASHBOARD =================
    Button studentInfoButton;
    Button academicRecordButton;
    Button viewStudentButton;
    Button logoutButton;
    Button exitButton;

    // ================= STUDENT INFORMATION =================
    TextField nameField;
    TextField rollField;
    TextField courseField;
    TextField branchField;
    TextField yearField;

    Button addStudentButton;
    Button updateStudentButton;
    Button deleteStudentButton;
    Button studentBackButton;

    // ================= ACADEMIC RECORD =================
    TextField academicRollField;
    TextField semesterField;
    TextField subjectField;
    TextField marksField;

    Button addAcademicButton;
    Button updateAcademicButton;
    Button deleteAcademicButton;
    Button academicBackButton;

    // ================= DATA STORAGE =================

    String studentName = "";
    String studentRoll = "";
    String studentCourse = "";
    String studentBranch = "";
    String studentYear = "";

    String academicRoll = "";
    String academicSemester = "";
    String academicSubject = "";
    String academicMarks = "";

    public Main() {
        showLoginPage();
    }

    // =========================================================
    // LOGIN PAGE
    // =========================================================

    void showLoginPage() {

        removeAll();

        setTitle("Student Information Management System");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        Label title = new Label("Student Information Management System");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(100, 50, 430, 40);
        add(title);

        Label subtitle = new Label("Login to continue");
        subtitle.setBounds(255, 95, 100, 25);
        add(subtitle);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setBounds(150, 145, 100, 25);
        add(usernameLabel);

        usernameField = new TextField();
        usernameField.setBounds(270, 145, 180, 25);
        add(usernameField);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setBounds(150, 190, 100, 25);
        add(passwordLabel);

        passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(270, 190, 180, 25);
        add(passwordField);

        loginButton = new Button("Login");
        loginButton.setBounds(250, 250, 100, 35);
        loginButton.addActionListener(this);
        add(loginButton);

        setVisible(true);
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    void showDashboard() {

        removeAll();

        setTitle("Student Information Management System - Dashboard");
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        Label title = new Label("Student Information Management System");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(150, 50, 450, 40);
        add(title);

        Label welcome = new Label("Welcome to Student Dashboard");
        welcome.setBounds(260, 100, 220, 25);
        add(welcome);

        // Student Information
        studentInfoButton = new Button("Student Information");
        studentInfoButton.setBounds(100, 160, 200, 50);
        studentInfoButton.addActionListener(this);
        add(studentInfoButton);

        // Academic Record
        academicRecordButton = new Button("Academic Record");
        academicRecordButton.setBounds(350, 160, 200, 50);
        academicRecordButton.addActionListener(this);
        add(academicRecordButton);

        // View
        viewStudentButton = new Button("View Student");
        viewStudentButton.setBounds(100, 240, 200, 50);
        viewStudentButton.addActionListener(this);
        add(viewStudentButton);

        // Logout
        logoutButton = new Button("Logout");
        logoutButton.setBounds(350, 240, 200, 50);
        logoutButton.addActionListener(this);
        add(logoutButton);

        // Exit
        exitButton = new Button("Exit");
        exitButton.setBounds(250, 330, 200, 45);
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    // =========================================================
    // STUDENT INFORMATION PAGE
    // =========================================================

    void showStudentInformation() {

        removeAll();

        setTitle("Student Information");
        setSize(650, 600);
        setLayout(null);
        setLocationRelativeTo(null);

        Label title = new Label("Student Information");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(220, 40, 250, 35);
        add(title);

        // Name
        Label nameLabel = new Label("Student Name:");
        nameLabel.setBounds(80, 110, 120, 25);
        add(nameLabel);

        nameField = new TextField();
        nameField.setBounds(220, 110, 250, 25);
        add(nameField);

        // Roll Number
        Label rollLabel = new Label("Roll Number:");
        rollLabel.setBounds(80, 155, 120, 25);
        add(rollLabel);

        rollField = new TextField();
        rollField.setBounds(220, 155, 250, 25);
        add(rollField);

        // Course
        Label courseLabel = new Label("Course:");
        courseLabel.setBounds(80, 200, 120, 25);
        add(courseLabel);

        courseField = new TextField();
        courseField.setBounds(220, 200, 250, 25);
        add(courseField);

        // Branch
        Label branchLabel = new Label("Branch:");
        branchLabel.setBounds(80, 245, 120, 25);
        add(branchLabel);

        branchField = new TextField();
        branchField.setBounds(220, 245, 250, 25);
        add(branchField);

        // Year
        Label yearLabel = new Label("Year:");
        yearLabel.setBounds(80, 290, 120, 25);
        add(yearLabel);

        yearField = new TextField();
        yearField.setBounds(220, 290, 250, 25);
        add(yearField);

        // ================= BUTTONS =================

        addStudentButton = new Button("Add");
        addStudentButton.setBounds(70, 360, 110, 35);
        addStudentButton.addActionListener(this);
        add(addStudentButton);

        updateStudentButton = new Button("Update");
        updateStudentButton.setBounds(200, 360, 110, 35);
        updateStudentButton.addActionListener(this);
        add(updateStudentButton);

        deleteStudentButton = new Button("Delete");
        deleteStudentButton.setBounds(330, 360, 110, 35);
        deleteStudentButton.addActionListener(this);
        add(deleteStudentButton);

        studentBackButton = new Button("Back");
        studentBackButton.setBounds(460, 360, 90, 35);
        studentBackButton.addActionListener(this);
        add(studentBackButton);

        setVisible(true);
    }

    // =========================================================
    // ACADEMIC RECORD PAGE
    // =========================================================

    void showAcademicRecord() {

        removeAll();

        setTitle("Academic Record");
        setSize(650, 550);
        setLayout(null);
        setLocationRelativeTo(null);

        Label title = new Label("Academic Record");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(230, 40, 220, 35);
        add(title);

        // Roll Number
        Label rollLabel = new Label("Roll Number:");
        rollLabel.setBounds(80, 110, 120, 25);
        add(rollLabel);

        academicRollField = new TextField();
        academicRollField.setBounds(220, 110, 250, 25);
        add(academicRollField);

        // Semester
        Label semesterLabel = new Label("Semester:");
        semesterLabel.setBounds(80, 155, 120, 25);
        add(semesterLabel);

        semesterField = new TextField();
        semesterField.setBounds(220, 155, 250, 25);
        add(semesterField);

        // Subject
        Label subjectLabel = new Label("Subject:");
        subjectLabel.setBounds(80, 200, 120, 25);
        add(subjectLabel);

        subjectField = new TextField();
        subjectField.setBounds(220, 200, 250, 25);
        add(subjectField);

        // Marks
        Label marksLabel = new Label("Marks:");
        marksLabel.setBounds(80, 245, 120, 25);
        add(marksLabel);

        marksField = new TextField();
        marksField.setBounds(220, 245, 250, 25);
        add(marksField);

        // ================= BUTTONS =================

        addAcademicButton = new Button("Add");
        addAcademicButton.setBounds(70, 320, 110, 35);
        addAcademicButton.addActionListener(this);
        add(addAcademicButton);

        updateAcademicButton = new Button("Update");
        updateAcademicButton.setBounds(200, 320, 110, 35);
        updateAcademicButton.addActionListener(this);
        add(updateAcademicButton);

        deleteAcademicButton = new Button("Delete");
        deleteAcademicButton.setBounds(330, 320, 110, 35);
        deleteAcademicButton.addActionListener(this);
        add(deleteAcademicButton);

        academicBackButton = new Button("Back");
        academicBackButton.setBounds(460, 320, 90, 35);
        academicBackButton.addActionListener(this);
        add(academicBackButton);

        setVisible(true);
    }

    // =========================================================
    // VIEW STUDENT
    // =========================================================

    void showViewStudent() {

        removeAll();

        setTitle("View Student Information");
        setSize(650, 550);
        setLayout(null);
        setLocationRelativeTo(null);

        Label title = new Label("Student Information");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(220, 40, 250, 35);
        add(title);

        TextArea information = new TextArea();
        information.setBounds(100, 110, 450, 280);
        information.setEditable(false);

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            StringBuilder data = new StringBuilder();

            while (rs.next()) {
                data.append("Student Name : ")
                        .append(rs.getString("name")).append("\n");
                data.append("Roll Number  : ")
                        .append(rs.getString("roll_number")).append("\n");
                data.append("Course       : ")
                        .append(rs.getString("course")).append("\n");
                data.append("Branch       : ")
                        .append(rs.getString("branch")).append("\n");
                data.append("Year         : ")
                        .append(rs.getString("year")).append("\n\n");
                data.append("--------------------------------\n\n");
            }

            if (data.length() == 0) {
                information.setText("No student records found.");
            } else {
                information.setText(data.toString());
            }

            rs.close();
            pst.close();
            con.close();

        } catch (SQLException ex) {
            information.setText("Error: " + ex.getMessage());
        }


        add(information);

        Button backButton = new Button("Back");
        backButton.setBounds(275, 430, 100, 35);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    // =========================================================
    // MESSAGE BOX
    // =========================================================

    void showMessage(String message) {

        Dialog dialog = new Dialog(this, "Message", true);

        dialog.setSize(350, 180);
        dialog.setLayout(new FlowLayout());
        dialog.setLocationRelativeTo(this);

        Label messageLabel = new Label(message);
        dialog.add(messageLabel);

        Button okButton = new Button("OK");

        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }

        });

        dialog.add(okButton);

        dialog.setVisible(true);
    }

    // =========================================================
    // ACTION LISTENER
    // =========================================================

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        // ================= LOGIN =================

        if (source == loginButton) {

            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();

            if (enteredUsername.equals("aarya") &&
                    enteredPassword.equals("aarya")) {

                showDashboard();

            } else {

                showMessage("Invalid username or password!");
            }
        }

        // ================= DASHBOARD =================

        else if (source == studentInfoButton) {

            showStudentInformation();

        }

        else if (source == academicRecordButton) {

            showAcademicRecord();

        }

        else if (source == viewStudentButton) {

            showViewStudent();

        }

        else if (source == logoutButton) {

            showLoginPage();

        }

        else if (source == exitButton) {

            System.exit(0);

        }

        // ================= STUDENT ADD =================

        else if (source == addStudentButton) {

            if (nameField.getText().isEmpty() ||
                    rollField.getText().isEmpty() ||
                    courseField.getText().isEmpty() ||
                    branchField.getText().isEmpty() ||
                    yearField.getText().isEmpty()) {

                showMessage("Please fill all fields.");

            } else {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "INSERT INTO students "
                            + "(roll_number, name, course, branch, year) "
                            + "VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, rollField.getText());
                    pst.setString(2, nameField.getText());
                    pst.setString(3, courseField.getText());
                    pst.setString(4, branchField.getText());
                    pst.setString(5, yearField.getText());

                    pst.executeUpdate();

                    pst.close();
                    con.close();

                    showMessage("Student added successfully!");

                } catch (SQLException ex) {
                    showMessage("Error: " + ex.getMessage());
                }
            }
        }

        // ================= STUDENT UPDATE =================

        else if (source == updateStudentButton) {

            String roll = rollField.getText().trim();

            if (roll.isEmpty()) {
                showMessage("Please enter the roll number.");
            } else {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "UPDATE students SET name=?, course=?, branch=?, year=? "
                            + "WHERE roll_number=?";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, nameField.getText());
                    pst.setString(2, courseField.getText());
                    pst.setString(3, branchField.getText());
                    pst.setString(4, yearField.getText());
                    pst.setString(5, roll);

                    int rows = pst.executeUpdate();

                    if (rows > 0) {
                        showMessage("Student updated successfully!");
                    } else {
                        showMessage("No student found with this roll number.");
                    }

                    pst.close();
                    con.close();

                } catch (SQLException ex) {
                    showMessage("Error: " + ex.getMessage());
                }
            }
        }

        // ================= STUDENT DELETE =================

        else if (source == deleteStudentButton) {

            String roll = rollField.getText().trim();

            if (roll.isEmpty()) {
                showMessage("Please enter the roll number.");
            } else {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "DELETE FROM students WHERE roll_number=?";
                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, roll);

                    int rows = pst.executeUpdate();

                    if (rows > 0) {
                        showMessage("Student deleted successfully!");

                        nameField.setText("");
                        rollField.setText("");
                        courseField.setText("");
                        branchField.setText("");
                        yearField.setText("");
                    } else {
                        showMessage("No student found with this roll number.");
                    }

                    pst.close();
                    con.close();

                } catch (SQLException ex) {
                    showMessage("Error: " + ex.getMessage());
                }
            }
        }

        // ================= ACADEMIC ADD =================

        else if (source == addAcademicButton) {

            if (academicRollField.getText().isEmpty() ||
                    semesterField.getText().isEmpty() ||
                    subjectField.getText().isEmpty() ||
                    marksField.getText().isEmpty()) {

                showMessage("Please fill all fields.");

            } else {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "INSERT INTO academic_records "
                            + "(roll_number, semester, subject, marks) "
                            + "VALUES (?, ?, ?, ?)";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, academicRollField.getText());
                    pst.setString(2, semesterField.getText());
                    pst.setString(3, subjectField.getText());
                    pst.setString(4, marksField.getText());

                    pst.executeUpdate();

                    pst.close();
                    con.close();

                    showMessage("Academic record added successfully!");

                } catch (SQLException ex) {
                    showMessage("Error: " + ex.getMessage());
                }
            }
        }

        // ================= ACADEMIC UPDATE =================

        else if (source == updateAcademicButton) {

            if (academicRoll.equals("")) {

                showMessage("No academic record to update.");

            } else {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "UPDATE academic_records SET marks=? "
                            + "WHERE roll_number=? AND semester=? AND subject=?";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, marksField.getText());
                    pst.setString(2, academicRollField.getText());
                    pst.setString(3, semesterField.getText());
                    pst.setString(4, subjectField.getText());

                    int rows = pst.executeUpdate();

                    if (rows > 0) {
                        showMessage("Academic record updated!");
                    } else {
                        showMessage("Academic record not found.");
                    }

                    pst.close();
                    con.close();

                } catch (SQLException ex) {
                    showMessage("Error: " + ex.getMessage());
                }
            }
        }

        // ================= ACADEMIC DELETE =================

        else if (source == deleteAcademicButton) {

            if (academicRoll.equals("")) {

                showMessage("No academic record to delete.");

            } else {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "DELETE FROM academic_records "
                            + "WHERE roll_number=? AND semester=? AND subject=?";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, academicRollField.getText());
                    pst.setString(2, semesterField.getText());
                    pst.setString(3, subjectField.getText());

                    int rows = pst.executeUpdate();

                    if (rows > 0) {
                        showMessage("Academic record deleted!");

                        academicRollField.setText("");
                        semesterField.setText("");
                        subjectField.setText("");
                        marksField.setText("");
                    } else {
                        showMessage("Academic record not found.");
                    }

                    pst.close();
                    con.close();

                } catch (SQLException ex) {
                    showMessage("Error: " + ex.getMessage());
                }
            }
        }

        // ================= BACK BUTTONS =================

        else if (source == studentBackButton ||
                source == academicBackButton) {

            showDashboard();
        }

        else if (source instanceof Button &&
                ((Button) source).getLabel().equals("Back")) {

            showDashboard();
        }
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        Main app = new Main();

        app.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }

        });
    }
}