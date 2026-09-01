package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class Session {
  private Integer id;
  private boolean authorized;
  //Definidas private para segurança. Posteriormente adicionar getters e setters para realizar a leitura a partir de outras classes.

  public void startSession() {
    System.out.println("""
            Como você deseja iniciar uma sessão?
            1 - Login
            2 - Cadastro
            """);
    Scanner scanner=new Scanner(System.in);
    String input=scanner.nextLine();
    if(input.equals("1")) {
      Login login=new Login();
      login.login();
    } else if(input.equals("2")) {
      SignUp signUp=new SignUp();
    } else {
      System.out.println("Operação inválida.");
    }
  }
}
