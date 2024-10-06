import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class DialogMenu {
    private List<Doctor> doctors = new ArrayList<>();


    public void showMenu() {
        boolean running = true;

        while (running) {
            String[] options = {"Add Doctor", "View Doctors", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Select an option",
                    "Doctor Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    addDoctor();
                    break;
                case 1:
                    viewDoctors();
                    break;
                case 2:
                    running = false;  //exit
                    break;
                default:
                    break;
            }
        }
    }

    private void addDoctor() {
        try {
            String name = JOptionPane.showInputDialog("Enter Doctor's Name:");
            String ageString = JOptionPane.showInputDialog("Enter Doctor's Age:");
            String specialty = JOptionPane.showInputDialog("Enter Doctor's Specialty:");

            int age = Integer.parseInt(ageString);


            Doctor newDoctor = new Doctor(name, age, specialty);

            doctors.add(newDoctor);

            // Display a message to the user indicating that the doctor was added successfully
            JOptionPane.showMessageDialog(null, "Doctor added successfully!\n" + newDoctor.toString());

        } catch (NumberFormatException e) {
            // error if the user enters a non-numeric value for age
            JOptionPane.showMessageDialog(null, "Invalid age entered. Please enter a valid number for age.");
        }
    }

    private void viewDoctors() {
        if (doctors.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No doctors available.");
        } else {
            StringBuilder doctorsList = new StringBuilder("Doctors:\n");
            for (Doctor doctor : doctors) {
                doctorsList.append(doctor.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, doctorsList.toString());
        }
    }
}

