public class Funcionario {
  private String id;
  private String nome;
  private String cpf;
  private String email;
  private String telefone;
  private String endereco;
  private double salario;

  public Funcionario(String id, String nome, String cpf, String email, String telefone, String endereco, double salario) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.telefone = telefone;
    this.endereco = endereco;
    this.salario = salario;
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

  public double getSalario() {
    return this.salario;
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
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}

class Tosador extends Funcionario {
  private float avaliacao_media;
  private int num_atendimentos;

  public Tosador(String id, String nome, String cpf, String email, String telefone, String endereco, double salario) {
    super(id, nome, cpf, email, telefone, endereco, salario);
    this.num_atendimentos = 0;
    this.avaliacao_media = 0;
  }

  public void setAvaliacao(float avaliacao) {
    this.avaliacao_media = avaliacao;
  }

  public void setNumAtendimentos(int num_atendimentos) {
    this.num_atendimentos = num_atendimentos;
  }

  public float getAvaliaca_omedia() {
    return this.avaliacao_media;
  }

  public float getNum_atendimentos() {
    return this.num_atendimentos;
  }

  public void novaAvaliacao(float avaliacao) {
    num_atendimentos++;
    avaliacao_media = (avaliacao_media*num_atendimentos-1 + avaliacao)/num_atendimentos;
  }
}

class Gerente extends Funcionario {
  public Gerente(String id, String nome, String cpf, String email, String telefone, String endereco, double salario) {
    super(id, nome, cpf, email, telefone, endereco, salario);
  }
}