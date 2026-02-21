import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FrontDesk {
    public void registerPatient(Scanner sc, Connection conn){
        System.out.println("\n------------------Enter Patient Details------------------\n");

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Patient Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Patient Phone: ");
        String phone = sc.nextLine();

        System.out.println("\n\nProcessing...\n");

        try{
            String query = "INSERT INTO patient(name, age, gender, phone) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);

            ps.executeUpdate();

            System.out.println("Patient Registered\n");
        }
        catch (SQLException e){
            System.out.println("Registration Failed :" + e);
        }
    }

    public void bookAppointment(Scanner sc, Connection conn){
        System.out.println("\n------------------Enter Patient Details------------------\n");

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Patient Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Patient Phone: ");
        String phone = sc.nextLine();

        System.out.println("\n\nProcessing...\n");

        try{
            String query = "INSERT INTO appointment(name, age, disease, gender, phone) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.setString(4, gender);
            ps.setString(5, phone);

            ps.executeUpdate();

            System.out.println("Appointment Booked\n");
        }
        catch (SQLException e){
            System.out.println("Appointment Booking Failed :" + e);
        }
    }

    public void dischargePatient(Scanner sc, Connection conn){
        System.out.print("\nEnter Patient ID");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.println("\n\n Processing...\n");

        try{
            String query = "DELETE FROM patient where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("\nPatient Discharged\n");
            }
            else{
                System.out.println("\nInvalid ID\n");
            }
        }
        catch (SQLException e){
            System.out.println("Patient Discharge Failed :" + e);
        }
    }

    public void getPatientDetails(Scanner sc, Connection conn){
        System.out.print("\nEnter Patient Phone: ");
        String patientPhone = sc.nextLine();

        System.out.println("\n\n Processing...\n");

        try{
            String query = "SELECT * FROM patient where phone = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, patientPhone);

            ResultSet rs = ps.executeQuery();
            boolean found = false;

            if(rs.next()){
                found = true;

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Phone: " + rs.getString("phone"));
            }

            if(found){
                System.out.println("Invalid ID\n");
            }
        }
        catch (SQLException e){
            System.out.println("Patient Data Fetching Failed :" + e);
        }
    }

    public void showAllPatients(Connection conn){
        try {
            System.out.println("\n\n Processing...\n");
            String query = "SELECT * FROM patient";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while(rs.next()){
                found = true;

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Phone: " + rs.getString("phone"));
            }

            if(found){
                System.out.println("Invalid ID\n");
            }
        }
        catch (SQLException e){
            System.out.println("Patients Data Fetching Failed :" + e);
        }
    }

    public void showAllBookings(Connection conn){
        try {
            System.out.println("\n\n Processing...\n");
            String query = "SELECT * FROM appointment";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Disease: " + rs.getString("disease"));
                    System.out.println("Gender: " + rs.getString("gender"));
                    System.out.println("Phone: " + rs.getString("phone"));
                }
            }
            else{
                System.out.println("Invalid ID\n");
            }
        }
        catch (SQLException e){
            System.out.println("Appointment Data Fetching Failed :" + e);
        }
    }

}
