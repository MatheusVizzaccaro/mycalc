package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class Session {
  private Integer id;
  private String username;
  private String password;
  private boolean authorized;

  public Session(Integer id, String username, String password, Boolean authorized) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.authorized = authorized;
  }

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
      return;
    } else {
      System.out.println("Operação inválida.");
    }
  }

  public boolean login() {
    Scanner scanner=new Scanner(System.in);

    System.out.println("Digite seu username:");
    username = scanner.nextLine();
    System.out.println("Digite sua senha:");
    username = scanner.nextLine();

    Login login = new Login(username, password);

    if(!login.isValidLogin()) {
      System.out.println("Credenciais inválidas");
      setAuthorized(false);
      return false;
    } else {
      setAuthorized(true);
      System.out.println("Acesso liberado");
      return true;
    }
  }

//  public boolean signUp() {
//    Scanner scanner = new Scanner(System.in);
//
//    System.out.println("Digite o nome de usuário desejado:");
//    username = scanner.nextLine();
//    System.out.println("Digite sua senha:");
//    password = scanner.nextLine();
//
//    SignUp signUp=new SignUp();
//    //todo sign up logic as login logic
//  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id=id;
  }

  public boolean isAuthorized() {
    return authorized;
  }

  private void setAuthorized(boolean authorized) {
    this.authorized=authorized;
  }
}
