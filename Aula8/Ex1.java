package Aula8;

public class Ex1 {
    public static Empresa empresa = new Empresa("Pequenos Quimboios", "1234-123", "pequenosquimboiosportugal@gmail.com");
    public static void main(String[] args) {
        System.out.println(empresa);
        empresa.addVeiculo(new Taxi("AB-12-34", "Ford", "Focus", 125, 0000, 130, 12345));
		empresa.addVeiculo(new Mercadorias("CD-56-LO", "Ford", "Pesado", 150, 9876, 7500, 3000));
		empresa.addVeiculo(new Passageiros("LO-09-PL", "Caetano", "AutocarroBus", 250, 5498, 10000, 50));
		empresa.addVeiculo(new Ligeiro("GH-JK-66", "BMW", "i8", 340, 0000, 130));
		empresa.addVeiculo(new Motociclo("GH-JK-66", "Honda", "MotaF", 100, "desportivo"));
        System.out.println(empresa);
        
        System.out.println("\n");

        System.out.println(empresa.getVeiculo("AB-12-34").equals(new Taxi("ab-12-34", "Ford", "Focus", 125, 0000, 130, 12345)));	//true
		System.out.println(empresa.getVeiculo("ab-12-34").equals(new Taxi("CD-45-12", "Ford", "Focus", 125, 0000, 130, 12345)));	//false

        System.out.println("\n");

        System.out.println(empresa.getVeiculo("CD-56-LO")); 
		Taxi T1=(Taxi)empresa.getVeiculo("CD-56-LO");
		T1.setQuadro(343);
		System.out.println(empresa.getVeiculo("CD-56-LO")); 
    }
}
