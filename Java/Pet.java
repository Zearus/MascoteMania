import java.util.*;
import java.io.*;

public class Pet {
  private String id;
  private String nome;
  private String especie;
  private String raca;
  private String idade;
  private String porte;
  private String sexo;

  public Pet(String id, String nome, String especie, String raca, String idade, String porte, String sexo) {
    this.id = id;
    this.nome = nome;
    this.especie = especie;
    this.raca = raca;
    this.idade = idade;
    this.porte = porte;
    this.sexo = sexo;
  }

  public Pet() {
  }

  public Pet(String id) throws FileNotFoundException {
    this.id = id;
    try {
      File file = new File("clientes.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      br.readLine();
      while ((line = br.readLine()) != null) {
        String[] tempArr = line.split(";");
        if (tempArr[0].equals(id)) {
          this.nome = tempArr[1];
          this.especie = tempArr[2];
          this.raca = tempArr[3];
          this.idade = tempArr[4];
          this.porte = tempArr[5];
          this.sexo = tempArr[6];
        }
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

public void geraId() throws FileNotFoundException {
    try {
      File file = new File("pets.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String Id = "0";
      String line = "";
      br.readLine();
      while ((line = br.readLine()) != null) {
        Id = line.split(";")[0];
      }
      this.id = Integer.parseInt(Id) + 1 + "";
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
}

public String getId() {
  return id;
}
  
public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEspecie() {
	return especie;
}

public void setEspecie(String especie) {
	this.especie = especie;
}

public String getRaca() {
	return raca;
}

public void setRaca(String raca) {
	this.raca = raca;
}

public String getIdade() {
	return idade;
}

public void setIdade(String idade) {
	this.idade = idade;
}

public String getPorte() {
	return porte;
}

public void setPorte(String porte) {
	this.porte = porte;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}
  
  @Override
    public String toString() {
      return nome + ";" + especie + ";" + raca + ";" + idade + ";" + porte + ";" + sexo + ";";
    }
}