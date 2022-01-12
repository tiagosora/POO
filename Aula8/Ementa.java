package Aula8;
import java.util.*;

public class Ementa {
	String nome, local;
	Map <String, ArrayList<Prato>> pratos = new HashMap<>();
	public Ementa(String nome, String local) {
		this.nome=nome;
		this.local=local;
		pratos.put("Segunda", new ArrayList<Prato>());
		pratos.put("Terça", new ArrayList<Prato>());
		pratos.put("Quarta", new ArrayList<Prato>());
		pratos.put("Quinta", new ArrayList<Prato>());
		pratos.put("Sexta", new ArrayList<Prato>());
		pratos.put("Sábado", new ArrayList<Prato>());
		pratos.put("Domingo", new ArrayList<Prato>());
	}
	public String getNome() {
		return nome;
	}
	public String getLocal() {
		return local;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void addPrato(Prato p, String diaSemana) {
		pratos.get(diaSemana).add(p);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
		for(ArrayList<Prato> p:(pratos.values())) {
			for(Prato pr:p) {
				result+=pr.hashCode();
			}
		}
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ementa))
			return false;
		Ementa other = (Ementa) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pratos == null) {
			if (other.pratos != null)
				return false;
		} else if (!pratos.equals(other.pratos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String s="\n\n";
		String[] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
		for(String dia:diasSemana) {
			for(Prato pr:pratos.get(dia)) {
				s+=pr.toString()+", dia "+dia+"\n";
			}
		}
		return s;
	}
}
