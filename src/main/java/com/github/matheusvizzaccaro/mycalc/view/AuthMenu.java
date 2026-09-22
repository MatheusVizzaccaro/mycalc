package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class AuthMenu {
  public Calculator choiceMenu() {
    System.out.println("""
            Como você deseja iniciar uma sessão?
            1 - Login
            2 - Cadastro
            """);

    Scanner scanner=new Scanner(System.in);
    String input=scanner.nextLine();

    if(input.equals("1")) {
      return displayCalculator();
    } else if(input.equals("2")) {
      signUp();
      return null;
    } else {
      System.out.println("Operação inválida.");
      return null;
    }
  }

  public Session login() {
    Scanner scanner=new Scanner(System.in);

    System.out.println("Digite seu username:");
    String username = scanner.nextLine();
    System.out.println("Digite sua senha:");
    String password = scanner.nextLine();

    Login login = new Login(username, password);

    if(!login.isValidLogin(login)) {
      System.out.println("Credenciais inválidas");
      return null;
    }

    System.out.println("Acesso liberado");
    return new Session(username, login.getId());
  }

  public boolean signUp() {
    //TODO ANALISAR SE ISSO PODE VIRAR VOID
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o nome de usuário desejado:");
    String username = scanner.nextLine();
    System.out.println("Digite sua senha:");
    String password = scanner.nextLine();

    SignUp signUp=new SignUp(username.trim(), password.trim());

    if(!signUp.setUserInfo(signUp)) {
      System.out.println("O cadastro não pode ser concluído");
      return false;
    }
    System.out.println("Cadastro concluído");
    return true;
  }

  private Calculator displayCalculator() {
    Session session = login();

    if(session != null) {
      return new Calculator(session);
    }
    return null;
  }
}
