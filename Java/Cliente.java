import java.util.ArrayList;

public class Cliente {
  private String id;
  private String nome;
  private String cpf;
  private String email;
  private String telefone;
  private String endereco;
  private ArrayList<Pet> pets;
  
  public Cliente(String id, String nome, String cpf, String email, String telefone, String endereco) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.telefone = telefone;
    this.endereco = endereco;
    this.pets = new ArrayList<Pet>();
  }

  public Cliente() {
  }

  public ArrayList<Pet> getPets() {
    return this.pets;
  }
  
  public String getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getEmail() {
    return this.email;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }

  public void setEndereco(String endereco) {
    this.endereco =  endereco;
  }

  public void adicionaPet(Pet pet) {
    this.pets.add(pet);
  }

  public void adicionaPet(String id, String nome, String especie, String raca, String idade, String porte, String sexo) {
    Pet pet = new Pet(id,nome,especie,raca,idade,porte,sexo);
    pets.add(pet);
  }

  public String getPetsID() {
    String temp = "";
    for (int i = 0; i < pets.size(); i++) {
      temp = temp + pets.get(i).getId();
    }
    return temp;
  }

  @Override
  public String toString() {
    return nome + ";" + cpf + ";" + email + ";" + telefone + ";" + endereco + ";" + pets + ";";
  }
  
}