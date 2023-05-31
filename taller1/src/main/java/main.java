import java.util.Scanner;

public class main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la Calculadora de Paquete de viajes");

        System.out.print("Igresa donde deseas viajar (Paris, New York City): ");
        String destination = scanner.nextLine();

        System.out.print("Ingresa cuantas personas viajaran: ");
        int numTravelers = scanner.nextInt();

        System.out.print("Ingresa el numero de dias que desea viajar: ");
        int duration = scanner.nextInt();

        // Validate input
        if (!isValidInput(destination, numTravelers, duration)) {
            System.out.println("Datos incorrectos");
            System.out.println("Tenga en cuenta que los tres datos sean validos");
            System.out.println("Los destinos deben ser Paris or New York City.");
            System.out.println("El numero de personas que viajran debe estar entre 1 a 80.");
            System.out.println("La duracion debe ser 1 o mas.");
            System.exit(0);
        }

        // Calculate base cost
        int costoBase = 1000;

        // Add additional cost based on the destination
        int additionalCost = 0;
        if (destination.equalsIgnoreCase("Paris")) {
            additionalCost = 500;
        } else if (destination.equalsIgnoreCase("New York City")) {
            additionalCost = 600;
        }

        // Calculate total cost
        int totalCost = costoBase + additionalCost;

        // Apply group discount
        double groupDiscount = 0;
        if (numTravelers > 4 && numTravelers <= 10) {
            groupDiscount = 0.1;
        } else if (numTravelers > 10) {
            groupDiscount = 0.2;
        }
        totalCost -= totalCost * groupDiscount;

        // Apply penalty fee for duration less than 7 days
        if (duration < 7) {
            totalCost += 200;
        }

        // Apply promotion policy
        if (duration > 30 || numTravelers == 2) {
            totalCost -= 200;
        }

        System.out.println("El costo total de la vacacion es: $" + totalCost);
    }   
    private static boolean isValidInput(String destination, int numTravelers, int duration) {
        return (destination.equalsIgnoreCase("Paris") || destination.equalsIgnoreCase("New York City")) &&
                numTravelers > 0 && numTravelers <= 80 && duration > 0;
    }
}
