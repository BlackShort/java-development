import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n------------------Hospital Management------------------ \n\n");
        Scanner sc = new Scanner(System.in);
        FrontDesk frontDesk = new FrontDesk();
        Connection conn = DatabaseConnection.getConnection();


        while(true){
            System.out.println("------------------Hospital Menu------------------");
            System.out.println("1. Register Patient");
            System.out.println("2. Book Appointment");
            System.out.println("3. Get Patient Details");
            System.out.println("4. Show All Patients");
            System.out.println("5. Show All Appointments");
            System.out.println("6. Discharge Patient");

            System.out.println("7. Exit\n");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    frontDesk.registerPatient(sc, conn);
                    break;
                case 2:
                    frontDesk.bookAppointment(sc, conn);
                    break;
                case 3:
                    frontDesk.getPatientDetails(sc, conn);
                    break;
                case 4:
                    frontDesk.showAllPatients(conn);
                    break;
                case 5:
                    frontDesk.showAllBookings(conn);
                    break;
                case 6:
                    frontDesk.dischargePatient(sc, conn);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    try{
                        conn.close();
                    }
                    catch (SQLException e){
                        System.out.println("Failed to Close Database Connection");
                    }
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}