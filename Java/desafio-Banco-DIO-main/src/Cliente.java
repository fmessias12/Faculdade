import java.util.Objects;

public class Cliente {

	public Banco banco;

	private String nome;

	public Cliente(String nome, Banco banco) {
		this.nome = nome;
		this.banco = banco;
		this.banco.clientes.add(this);

	}

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}
	
	public void setBanco(Banco banco) {
		this.banco = banco;
		this.banco.clientes.add(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(banco, other.banco) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente [banco=" + banco.nome + ", nome=" + nome + "]";
	}
	
	

}
