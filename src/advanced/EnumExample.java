package advanced;

enum Level{
    EASY,
    MEDIUM,
    HARD
}


public class EnumExample {
    public static void main(String[] args) {

        Level myLevel = Level.EASY;

        switch (myLevel){
            case EASY:
                System.out.println("Easy level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HARD:
                System.out.println("Hard level");
                break;
        }
    }
}
