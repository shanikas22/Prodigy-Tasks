import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get temperature input
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        // Get unit input
        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        // Perform conversion
        switch (unit) {
            case 'C': // Convert from Celsius
                double fahrenheit = (temperature * 9/5) + 32;
                double kelvin = temperature + 273.15;
                System.out.println("\nConverted Temperatures:");
                System.out.println("Fahrenheit: " + fahrenheit + "°F");
                System.out.println("Kelvin: " + kelvin + "K");
                break;

            case 'F': // Convert from Fahrenheit
                double celsiusFromF = (temperature - 32) * 5/9;
                double kelvinFromF = (temperature - 32) * 5/9 + 273.15;
                System.out.println("\nConverted Temperatures:");
                System.out.println("Celsius: " + celsiusFromF + "°C");
                System.out.println("Kelvin: " + kelvinFromF + "K");
                break;

            case 'K': // Convert from Kelvin
                double celsiusFromK = temperature - 273.15;
                double fahrenheitFromK = (temperature - 273.15) * 9/5 + 32;
                System.out.println("\nConverted Temperatures:");
                System.out.println("Celsius: " + celsiusFromK + "°C");
                System.out.println("Fahrenheit: " + fahrenheitFromK + "°F");
                break;

            default:
                System.out.println("Invalid unit. Please enter C, F, or K.");
        }
        scanner.close();
    }
}
