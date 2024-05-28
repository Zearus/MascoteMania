import java.util.*;
import java.io.*;

public class Main {
  public static void cadastra(String login, String senha) throws FileNotFoundException {
    try {
      File file = new File("clientes.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = "";
      String[] tempArr = { "0" };
      br.readLine();
      while ((line = br.readLine()) != null) {
        tempArr = line.split(";");
        if (tempArr[1].equals(login)) {
          System.out.println("Login já existe");
          return;
        }
      }
      br.close();
      int ID = Integer.parseInt(tempArr[0]) + 1;
      FileWriter fw = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(fw);
      Scanner s = new Scanner(System.in);
      Cliente cliente = new Cliente();
      System.out.println("Digite o nome do cliente:");
      cliente.setNome(s.nextLine());
      System.out.println("Digite o CPF do cliente:");
      cliente.setCpf(s.nextLine());
      System.out.println("Digite o e-mail do cliente:");
      cliente.setEmail(s.nextLine());
      System.out.println("Digite o telefone do cliente:");
      cliente.setTelefone(s.nextLine());
      System.out.println("Digite o endereço do cliente:");
      cliente.setEndereco(s.nextLine());
      bw.write(ID + ";" + login + ";" + senha + ";" + cliente + "\n");
      bw.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static void loginCliente(String login, String senha) throws FileNotFoundException {
    try {
      File file = new File("clientes.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = "";
      String[] tempArr = { "0" };
      Cliente cliente = null;
      br.readLine();
      while ((line = br.readLine()) != null) {
        tempArr = line.split(";");
        if (tempArr[1].equals(login) && tempArr[2].equals(senha)) {
          cliente = new Cliente(tempArr[0], tempArr[3], tempArr[4], tempArr[5], tempArr[6], tempArr[7]);
        }
      }
      br.close();
      if (cliente == null) {
        System.out.println("Login ou senha inválidos");
        return;
      }
      caminhoCliente(cliente);
      return;
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static void loginFuncionario(String login, String senha) throws FileNotFoundException {
    try {
      File file = new File("funcionarios.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = "";
      String[] tempArr = { "0" };
      Tosador tosador = null;
      Gerente gerente = null;
      br.readLine();
      while ((line = br.readLine()) != null) {
        tempArr = line.split(";");
        if (tempArr[1].equals(login) && tempArr[2].equals(senha)) {
          if (tempArr[3] == "Gerente") {
            gerente = new Gerente(tempArr[0], tempArr[3], tempArr[4], tempArr[5], tempArr[6], tempArr[7], Double.parseDouble(tempArr[8]));
          }
          else {
            tosador = new Tosador(tempArr[0], tempArr[3], tempArr[4], tempArr[5], tempArr[6], tempArr[7], Double.parseDouble(tempArr[8]));
            tosador.setAvaliacao(Float.parseFloat(tempArr[9]));
            tosador.setNumAtendimentos(Integer.parseInt(tempArr[10]));
          }
        }
      }
      br.close();
      if (tosador == null && gerente == null) {
        System.out.println("Login ou senha inválidos");
        return;
      }
      if (tosador == null) {
        caminhoGerente(gerente);
        return;
      }
      else {
        caminhoTosador(tosador);
        return;
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static void caminhoCliente(Cliente cliente) throws FileNotFoundException {
    Boolean caminhocliente = true;
    while (caminhocliente) {
      System.out.println("Bem vindo senhor " + cliente.getNome() + "!");
      System.out.println("O que deseja fazer?");
      System.out.println("1 - Menu de Pets");
      System.out.println("2 - Menu de serviços");
      System.out.println("3 - Menu de compras");
      System.out.println("0 - Sair");
      Scanner s = new Scanner(System.in);
      String option = s.nextLine();
      switch (option){
        case "1":
          System.out.println("Bem vindo ao menu de pets!");
          System.out.println("Digite 1 para adicionar novo pet");
          System.out.println("Digite 2 para remover pet");
          System.out.println("Digite 3 para ver seus pets");
          System.out.println("Digite 0 para sair");
          String option2 = s.nextLine(); 
          switch (option2) {
            case "1":
              Pet pet = new Pet();
              System.out.println("Digite o nome do pet:");
              pet.setNome(s.nextLine());
              System.out.println("Digite a especie do pet");
              pet.setEspecie(s.nextLine());
              System.out.println("Digite a raça do pet");
              pet.setRaca(s.nextLine());
              System.out.println("Digite a idade do pet");
              pet.setIdade(s.nextLine());
              System.out.println("Digite o porte do pet");
              pet.setPorte(s.nextLine());
              System.out.println("Digite o sexo do pet");
              pet.setSexo(s.nextLine());
              pet.geraId();
              cliente.adicionaPet(pet);
              break;
            case "3":
              for (int i = 0; i < cliente.getPets().size(); i++) {
                System.out.println(cliente.getPets().get(i));
              }
              break;
          }
          break;
        case "2":
          System.out.println("Bem vindo ao menu de serviços!");
          System.out.println("Digite 1 para agendar novo serviço");
          System.out.println("Digite 2 para remover serviço agendado");
          System.out.println("Digite 3 para listar os serviços agendados");
          System.out.println("Digite 0 para sair");
          break;
        case "3":
          System.out.println("Bem vindo ao menu de compras!");
          System.out.println("Digite 1 para comprar um novo produto para seu pet");
          System.out.println("Digite 2 para cancelar a entrega de um produto");
          System.out.println("Digite 3 para listar os produtos comprados");
          System.out.println("Digite 0 para sair");
          break;
        case "0":
          return;
        default:
          System.out.println("Opção inválida,tente novamente");
      }
    }
  }

  public static void caminhoTosador(Tosador tosador) {
    System.out.println("Bem vindo senhor " + tosador.getNome() + "!");
    System.out.println("O que deseja fazer?");
    System.out.println("1 - Menu de serviços");
    System.out.println("0 - Sair");
    Scanner s = new Scanner(System.in);
    String option = s.nextLine();
    switch (option) {
      case "1":
        System.out.println("Bem vindo ao menu de serviços!");
        System.out.println("Digite 1 para verificar sua lista de serviços");
        System.out.println("Digite 2 para alterar o estado de algum serviço");
        System.out.println("Digite 0 para sair");
        break;
      case "0":
        return;
    }
    return;
  }

  public static void caminhoGerente(Gerente gerente) {
    System.out.println("Bem vindo senhor " + gerente.getNome() + "!");
    System.out.println("O que deseja fazer?");
    System.out.println("1 - Menu de tosadores");
    System.out.println("2 - Menu de clientes");
    System.out.println("3 - Menu do Catálogo");
    System.out.println("0 - Sair");
    Scanner s = new Scanner(System.in);
    String option = s.nextLine(); 
    switch (option) {
      case "1":
        System.out.println("Bem vindo ao menu de tosadores!");
        System.out.println("Digite 1 para adicionar um novo tosador");
        System.out.println("Digite 2 para remover um tosador");
        System.out.println("Digite 3 para listar os tosadores");
        System.out.println("Digite 4 para criar um relatório dos tosadores");
        System.out.println("Digite 0 para sair");
        break;
      case "2": //Não é necessário
        System.out.println("Bem vindo ao menu de clientes!");
        System.out.println("Digite 1 para adicionar um novo cliente");
        System.out.println("Digite 2 para remover um cliente");
        System.out.println("Digite 3 para listar os clientes"); 
        System.out.println("Digite 0 para sair");
        break; 
      case "3": 
        System.out.println("Bem vindo ao menu do catálogo!");
        System.out.println("Digite 1 para adicionar um novo produto");
        System.out.println("Digite 2 para remover um produto");
        System.out.println("Digite 3 para listar os produtos");
        System.out.println("Digite 4 para alterar o preço de um produto");
        System.out.println("Digite 0 para sair");
        break;
    }
    return;
  }


  public static void main(String[] args) throws FileNotFoundException {
    Boolean program = true;
    String login;
    String senha;
    while (program) {
      System.out.println(
          "Bem vindo ao sistema da Mascote Mania\nPara começar, escolha uma das opções abaixo:\n1 - Cadastrar cliente\n2 - Logar no site\n0 - sempre que quiser voltar");
      Scanner s = new Scanner(System.in);
      String option = s.nextLine();
      switch (option) {
        case "1":
          System.out.println("Digite o login do cliente:");
          login = s.nextLine();
          System.out.println("Digite a senha do cliente:");
          senha = s.nextLine();
          cadastra(login, senha);
          break;
        case "2":
          System.out.println("Agora digite 1 se você for cliente e 2 se for funcionário");
          String logar = s.nextLine();
          switch (logar) {
            case "1":
              System.out.println("Digite o login do cliente:");
              login = s.nextLine();
              System.out.println("Digite a senha do cliente:");
              senha = s.nextLine();
              loginCliente(login, senha);
              break;
            case "2":
              System.out.println("Digite o login do cliente:");
              login = s.nextLine();
              System.out.println("Digite a senha do cliente:");
              senha = s.nextLine();
              loginFuncionario(login, senha);
              break;
            default:
              System.out.println("O valor inserido foi inválido");
              break;
          }
          break;
        case "0":
          s.close();
          program = false;
          break;
        default:
          System.out.println("Opcão inválida, tente novamente");
          break;
      }
    }
  }
}