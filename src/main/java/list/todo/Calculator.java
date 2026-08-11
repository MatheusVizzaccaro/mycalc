package list.todo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public void showCalc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a operação desejada: \n\n 01 - Soma \n 02 - Subtração");
        int option = scanner.nextInt();
        redirect(option);
    }

    public void redirect(int option) {
        if(option == 1) {
            System.out.println("Digite quais números você quer somar, separados por vírgula.\n(Ex: 10, 20)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] params = input.split(",");
            ArrayList<Integer> parsedParams = new ArrayList<>();

            for (int i=0;i<params.length;i++) {
                parsedParams.add(Integer.parseInt(params[i].trim()));
            }
        } else {
            System.out.println("Operação não conhecida.");
        }
    }
}
