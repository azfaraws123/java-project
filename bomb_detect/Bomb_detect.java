import java.util.Random;
import java.util.Scanner;

class Bomb {
    private int x;
    private int y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class BombDetectionSystem {
    private Bomb bomb;
    private final int gridSize;

    public BombDetectionSystem(int gridSize) {
        this.gridSize = gridSize;
        placeBomb();
    }

    private void placeBomb() {
        Random random = new Random();
        int x = random.nextInt(gridSize);
        int y = random.nextInt(gridSize);
        bomb = new Bomb(x, y);
    }

    public boolean detectBomb(int x, int y) {
        return bomb.getX() == x && bomb.getY() == y;
    }

    public void displayBombLocation() {
        System.out.println("Bomb is placed at coordinates: (" + bomb.getX() + ", " + bomb.getY() + ")");
    }
}

public class BombDetectionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grid size (NxN): ");
        int gridSize = scanner.nextInt();
        
        BombDetectionSystem detectionSystem = new BombDetectionSystem(gridSize);
        
        System.out.println("Bomb detection simulation started.");
        int attempts = 0;
        boolean bombDetected = false;

        while (!bombDetected) {
            System.out.print("Enter x coordinate to scan: ");
            int x = scanner.nextInt();
            System.out.print("Enter y coordinate to scan: ");
            int y = scanner.nextInt();

            attempts++;

            if (detectionSystem.detectBomb(x, y)) {
                System.out.println("Bomb detected at (" + x + ", " + y + ")! Attempts taken: " + attempts);
                bombDetected = true;
            } else {
                System.out.println("No bomb detected at (" + x + ", " + y + "). Try again.");
            }
        }
        
        detectionSystem.displayBombLocation();
        scanner.close();
    }
}
