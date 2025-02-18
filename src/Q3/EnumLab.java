package Q3;

public class EnumLab {
    enum Level {
        LOW,    // 0
        MEDIUM, // 1
        HIGH    // 2
    }

    public static void main(String[] args) {
        Level mylvl = Level.MEDIUM;
        switch (mylvl) {
            case LOW -> System.out.println("Low Level");
            case MEDIUM -> System.out.println("Medium Level");
            case HIGH -> System.out.println("High Level");
        }

        for (Level option : Level.values()) {
            System.out.println(option);
        }
        // Enums can be treated like classes with methods, attributions, and interfaces
        // But enum constraints are "public static final"
    }
}
