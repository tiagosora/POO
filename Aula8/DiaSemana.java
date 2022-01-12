package Aula8;

import java.lang.Math;

public interface DiaSemana {
	String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
	static String rand() {
		int i = (int)(Math.random()*7);
		return dias[i];
	}
}
