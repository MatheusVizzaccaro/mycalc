package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class Session {
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
      setId(login.getUserId());
      if(getId() == null) {
        System.out.println("Credenciais inválidas");
      } else {
        setAuthorized(true);
        System.out.println("Acesso liberado");
      }
    } else if(input.equals("2")) {
      SignUp signUp=new SignUp();
    } else {
      System.out.println("Operação inválida.");
    }
  }
}
