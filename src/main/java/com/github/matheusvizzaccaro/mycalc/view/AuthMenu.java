package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class AuthMenu {
  public void choiceMenu() {
    System.out.println("""
            Como você deseja iniciar uma sessão?
            1 - Login
            2 - Cadastro
            """);

    Scanner scanner=new Scanner(System.in);
    String input=scanner.nextLine();

    if(input.equals("1")) {
      login();
    } else if(input.equals("2")) {
      signUp();
    } else {
      System.out.println("Operação inválida.");
    }
  }

  public Session login() {
    Scanner scanner=new Scanner(System.in);

    System.out.println("Digite seu username:");
    String username = scanner.nextLine();
    System.out.println("Digite sua senha:");
    String password = scanner.nextLine();

    Login login = new Login(username, password);

    if(!login.isValidLogin()) {
      System.out.println("Credenciais inválidas");
      return null;
    }

    System.out.println("Acesso liberado");
    Session session = new Session(username, login.getId());
    return session;
  }

  public boolean signUp() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o nome de usuário desejado:");
    String username = scanner.nextLine();
    System.out.println("Digite sua senha:");
    String password = scanner.nextLine();

    SignUp signUp=new SignUp(username, password);

    if(!signUp.setUserInfo()) {
      System.out.println("O cadastro não pode ser concluído");
      return false;
    }
    System.out.println("Cadastro concluído");
    return true;
  }
}
