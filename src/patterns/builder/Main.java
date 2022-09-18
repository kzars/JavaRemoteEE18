package patterns.builder;

public class Main {
    public static void main(String[] args) {

        User user1 = new User.UserBuilder("Kārlis", "Zars")
                .age(50)
                .phone("+37133242343")
                .address("Riga")
                .build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Antonio","Banderas")
                .age(62)
                .phone("23423343")
                // no address
                .build();

        System.out.println(user2);

        User user3 = new User.UserBuilder("Bob", "Test").build();

        System.out.println(user3);

    }
}
