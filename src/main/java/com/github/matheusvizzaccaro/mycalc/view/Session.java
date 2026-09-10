package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class Session {
  private Integer id;
  private String username;
  private boolean authorized;

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
    Login login=new Login();
    setId(login.getUserId());

    if(getId() == null) {
      System.out.println("Credenciais inválidas");
      return false;
    } else {
      setAuthorized(true);
      System.out.println("Acesso liberado");
      return true;
    }
  }

//  public boolean signUp() {
//    SignUp signUp=new SignUp();
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

  public void setAuthorized(boolean authorized) {
    this.authorized=authorized;
  }
}
