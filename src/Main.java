import java.util.Scanner;

// Класс, описывающий пользователя
class User {
    private String name;
    private int age;
    private int[] scores;

    public User(String name, int age, int[] scores) {
        this.name = name;
        this.age = age;
        this.scores = scores;
    }

    public double averageScore() {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return scores.length == 0 ? 0.0 : (double) sum / scores.length;
    }

    public void printInfo() {
        System.out.println("Имя: " + name + ", возраст: " + age);
        System.out.print("Оценки: ");
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Средний балл: " + averageScore());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // ввод с клавиатуры [web:37][web:40]

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите возраст: ");
        int age = in.nextInt();

        System.out.print("Сколько будет оценок? ");
        int n = in.nextInt();

        int[] scores = new int[n];           // массив оценок [web:41][web:44]
        for (int i = 0; i < n; i++) {
            System.out.print("Оценка " + (i + 1) + ": ");
            scores[i] = in.nextInt();
        }

        User user = new User(name, age, scores); // объект собственного класса [web:42][web:48][web:54]
        System.out.println();
        user.printInfo();

        in.close();
    }
}
