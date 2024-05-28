public class Agendamento {
  private String id;
  private String data;
  private String hora;
  private String servico;
  private Cliente cliente;
  private Pet pet;
  private Tosador tosador;
  private float avaliacao;
  private String status;
  public String observacoes;

  public Agendamento (String id, String data, String hora, String servico, Cliente cliente, Pet pet, Tosador tosador) {
    this.id = id;
    this.data = data;
    this.hora = hora;
    this.servico = servico;
    this.cliente = cliente;
    this.pet = pet;
    this.tosador = tosador;
    this.status = "agendado";
    this.observacoes = "";
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  public String getData() {
    return data;
  }
  
  public String getHora() {
	 return hora;
  }
  
  public void setHora(String hora) {
	 this.hora = hora;
  }
  public String getServico() {
	 return servico;
  }
  
  public Cliente getCliente() {
	 return cliente;
  }
  
  public Pet getPet() {
	 return pet;
  }
  
  public Tosador getTosador() {
	 return tosador;
  }
  
  public float getAvaliacao() {
	 return avaliacao;
  }
  
  public void setAvaliacao(float avaliacao) {
	 this.avaliacao = avaliacao;
  }
  
  public String getStatus() {
	 return status;
  }
  
  public void setStatus(String status) {
	 this.status = status;
  }
  
  public String getObservacoes() {
	 return observacoes;
  }
  
  public void setObservacoes(String observacoes) {
	 this.observacoes = observacoes;
  }
}