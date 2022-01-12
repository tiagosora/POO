package Aula8;
import Aula8.Carne.Variedade;
import Aula8.Peixe.Tipo;

public class A08E02 {

	public static void main(String[] args) {
		Ementa ementa = new Ementa("Especial Primavera", "Snack da UA");
		Prato[] pratos = new Prato[10];

		for (int i = 0; i < pratos.length; i++) {
			pratos[i] = randPrato(i + 1);
			System.out.println("A sair .. " + pratos[i]);

			int ingred = 1;
			do {
				Alimento aux = randAlimento();
				if (pratos[i].addIngrediente(aux)) {
					System.out.println("\tIngrediente " + ingred + " adicionado: " + aux);
					ingred++;
				} else
					System.out.println("\tERRO: não é possível adicionar Ingrediente " + ingred + ": " + aux);
			} while (ingred < 3);
			String diaSemana = DiaSemana.rand();
			ementa.addPrato(pratos[i], diaSemana);
		}
		System.out.println("\nEmenta final\n--------------------");
		System.out.println(ementa);
	}

	public static Alimento randAlimento() {
		Alimento res = null;
		switch ((int) (Math.random() * 4)) {
		case 0:
			res = new Carne( 22.3, 345.3, 300, Variedade.frango);
			break;
		case 1:
			res = new Peixe(31.3, 25.3, 200, Tipo.congelado);
			break;
		case 2:
			res = new Legume( 21.3, 22.4, 150, "Couve Flor");
			break;
		case 3:
			res = new Cereal( 19.3, 32.4, 110, "Milho");
			break;
		}
		return res;
	}

	public static Prato randPrato(int i) {
		Prato res = null;
		switch ((int) (Math.random() * 3)) {
		case 0:
			res = new Prato("combinado n." + i);
			break;
		case 1:
			res = new PratoVegetariano("combinado n." + i);
			break;
		case 2:
			res = new PratoDieta("combinado n." + i, 90.8);
			break;
		}
		return res;
	}

}
