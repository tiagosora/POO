package Aula7;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Ex2 {
    public static final Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static Robo A = new Robo(8, 7, "A", "Avancado");
    public static Robo B = new Robo(8, 5, "B", "Defesa");
    public static Robo C = new Robo(8, 3, "C", "Medio");
    public static Robo D = new Robo(0, 5, "D", "GuardaRedes");
    public static Robo E = new Robo(12, 7, "E", "Avancado");
    public static Robo F = new Robo(12, 5, "F", "Defesa");
    public static Robo G = new Robo(12, 3, "G", "Medio");
    public static Robo H = new Robo(20, 5, "H", "GuardaRedes");
    public static Bola bola = new Bola(10, 5, "preta");
    public static Equipa kd = new Equipa("KD", "Sora");
    public static Equipa gtz = new Equipa("GTZ", "Ryu");
    public static Jogo jogo = new Jogo(bola);
        

    public static void main(String[] args) {
        /*
        LISTA DAS AÇOES POSSIVEIS
        #OS JOGADORES SO SE PODEM MOVER 2 QUADRADOS POR X E/OU Y
        #O GUARDA REDES É CANSADO E NAO SE MOVE
        #NAO HA PASSES PORQUE SAO INDIVIDUALISTAS
        PEGAR A BOLA
            QD ESTE MOVIMENTO ACONTECE TODOS OS JOGADORES DA EQUIPA INIMIGA SE MOVEM NA DIREÇAO DA BOLA (QUE NAO SEJA O GUARDA REDES)
            QD ESTE MOVIMENTO ACONTECE TODOS OS JOGADORES DA EQUIPA QUEM TEM A BOLA MOVEM SE NA DIREÇAO DA BALIZA INIMIGA
            TEM CHANCE DE FRANCASSAR, PORQUE O JOGADOR NA POSSE DE BOLA PODE SER O RONALDO
        MOVIMENTO RANDOM DO JOGADOR COM A BOLA (QUE NAO SEJA O GUARDA REDES)
            QD ESTE MOVIMENTO ACONTECE TODOS OS JOGADORES DA EQUIPA INIMIGA SE MOVEM NA DIREÇAO DA BOLA (QUE NAO SEJA O GUARDA REDES)
            QD ESTE MOVIMENTO ACONTECE TODOS OS JOGADORES DA EQUIPA QUEM TEM A BOLA MOVEM SE NA DIREÇAO DA BALIZA INIMIGA
            PODE FICAR NO MESMO SITIO PARA RECUPERAR O FOLEGO
        MOVIMENTO RANDOM DE UM JOGADOR SEM A BOLA (QUE NAO SEJA O GUARDA REDES)
            É APENAS UM MOVIMENTO DE UM AUTISTA QUALQUER SEM SONHOS
            PODE FICAR NO MESMO SITIO PARA RECUPERAR O FOLEGO
        O JOGADOR NA POSSE DE BOLA MARCAR GOLO
            TEM DE ESTAR PERTO DA BALIZA
            TEM UM CHANCE, PORQUE O GUARDA REDES NAO É O ROBERTO :)
        O GUARDA REDES PODER DEFENDER
            O GUARDA REDES PASSA PARA O JOGADOR Q ELE QUISER MENOS O QUE ESTA MAIS PERTO DA BALIZA
            QD ESTE MOVIMENTO ACONTECE TODOS OS JOGADORES DA EQUIPA INIMIGA SE MOVEM NA DIREÇAO DA BOLA (QUE NAO SEJA O GUARDA REDES)
            QD ESTE MOVIMENTO ACONTECE TODOS OS JOGADORES DA EQUIPA QUEM TEM A BOLA MOVEM SE NA DIREÇAO DA BALIZA INIMIGA
        */
        kd.addRobos(A); kd.addRobos(B); kd.addRobos(C); kd.addRobos(D);
        gtz.addRobos(E); gtz.addRobos(F); gtz.addRobos(G); gtz.addRobos(H);
        ArrayList<Equipa> equipas = new ArrayList<>();
        equipas.add(kd); equipas.add(gtz);
        jogo.setEquipas(equipas);
        gameAction();
        
    }
    public static void gameAction(){
        int n = rand.nextInt(10); 
        action(n);
    }
    public static void action(int n){
        if (n > 7){
            pegarbola();
            marcarGolo(); 
            gameAction();
        } else if (n > 4){
            moverBola();
            marcarGolo(); 
            gameAction();
        } else {
            retarmovese();
            gameAction();
        }
    }
    public static void pegarbola(){
        //selcionar uma equipa
        int a = rand.nextInt(2);
        int e = 1-a;
        //saber se a equipa tem bola
        int checkbola = 0;
        for (int i = 0; i < jogo.getEquipas().get(a).getRobos().size(); i++){
            if (jogo.getEquipas().get(a).getRobos().get(i).getPosseBola() == true){
                checkbola = 1;
            }
        }
        //caso a equipa nao tenha bola
        if (checkbola == 0){
            //saber onde esta a bola
            int xbola = jogo.getBola().getX();
            int ybola = jogo.getBola().getY();
            //saber quem são os jogadores q podem alcança la com movimento de max
            ArrayList<Integer> jogadores = new ArrayList<>();
            for (int i = 0; i < jogo.getEquipas().get(a).getRobos().size(); i++){
                if (Math.abs(jogo.getEquipas().get(a).getRobos().get(i).getX() - xbola) < 3 && Math.abs(jogo.getEquipas().get(a).getRobos().get(i).getY() - ybola) < 3){
                    if (jogo.getEquipas().get(a).getRobos().get(i).getTipoString() != "GuardaRedes") {
                        jogadores.add(i);
                    }
                }
            }
            //Escolher um jogador para pegar a bola
            if (jogadores.size() > 0) {
                int index = jogadores.get(rand.nextInt(jogadores.size()));
                //mover e pegar a bola
                jogo.getEquipas().get(a).getRobos().get(index).move(xbola, ybola);
                jogo.getEquipas().get(a).getRobos().get(index).setPosseBola(true);
                System.out.println("O jogador " + jogo.getEquipas().get(a).getRobos().get(index).getId() + " moveu-se para [" + xbola + ", " + ybola + "] e pegou na bola!");
                jogo.addTempoDecorrido(rand.nextInt(7));
                for (int i = 0; i < jogo.getEquipas().get(e).getRobos().size(); i++){
                    jogo.getEquipas().get(e).getRobos().get(i).setPosseBola(false);
                }
            }
        }
    }
    public static void retarmovese(){
        //selcionar uma equipa
        int a = rand.nextInt(2);
        //saber quem são os jogadores q podem se mover retardadamente
        ArrayList<Integer> jogadores = new ArrayList<>();
        for (int i = 0; i < jogo.getEquipas().get(a).getRobos().size(); i++){
            if (jogo.getEquipas().get(a).getRobos().get(i).getPosseBola() == false){
                if (jogo.getEquipas().get(a).getRobos().get(i).getTipoString() != "GuardaRedes") {
                   jogadores.add(i); 
                }
            }
        }
        //Escolher um jogador
        if (jogadores.size() > 0){
            int index = jogadores.get(rand.nextInt(jogadores.size()));
            //move lo retardadamente
            int newX = rand.nextInt(19) + 1;
            int newY = rand.nextInt(9) + 1;
            jogo.getEquipas().get(a).getRobos().get(index).move(newX, newY);
            jogo.addTempoDecorrido(rand.nextInt(7));
            System.out.println("O jogador " + jogo.getEquipas().get(a).getRobos().get(index).getId() + " moveu-se para [" + newX + ", " + newY + "]");
        }
    }
    public static void moverBola(){
        //Saber que equipa tem a bola
        int a = 0;
        for (int i = 0; i < jogo.getEquipas().get(1).getRobos().size(); i++){
            if (jogo.getEquipas().get(1).getRobos().get(i).getPosseBola() == true){
                a = 1;
            }
        }
        //Saber que jogador tem a bola (0 é apenas para iniciar)
        int indexjogadorbola = 0;
        for (int i = 0; i < jogo.getEquipas().get(a).getRobos().size(); i++){
            if (jogo.getEquipas().get(a).getRobos().get(i).getPosseBola() == true){
                indexjogadorbola = i;
            }
        }
        //Mover o jogador com bola
        int xjogadorbola = jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).getX();
        int yjogadorbola = jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).getY();
        int dy = Math.abs(yjogadorbola - 5);
        int newXbola, newY;
        //mover no Y
        if (dy == 0){
            if (yjogadorbola > 5){
                newY = 5 - rand.nextInt(2);
            } else {
                newY = 5 + rand.nextInt(2);
            }
        } else {
            if (yjogadorbola > 5){
                newY = yjogadorbola - rand.nextInt(3);
            } else {
                newY = yjogadorbola + rand.nextInt(3);
            }
        }
        //mover no X
        if (a == 0){
            newXbola = xjogadorbola + rand.nextInt(3);
        } else {
            newXbola = xjogadorbola - rand.nextInt(3);
        }
        if (newXbola > 19 || newXbola < 1){
            newXbola = xjogadorbola;
        }
        jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).move(newXbola, newY);
        jogo.getBola().move(newXbola, newY);
        System.out.println("O jogador "+jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).getId()+" moveu-se com a bola para [" + newXbola + ", " + newY + "]. ");
        //mover os outros da equipa
        for (int i = 0; i < jogo.getEquipas().get(a).getRobos().size(); i++){
            if (jogo.getEquipas().get(a).getRobos().get(i).getPosseBola() == false){
                if (jogo.getEquipas().get(a).getRobos().get(i).getTipoString() != "GuardaRedes") {
                    int xjogador = jogo.getEquipas().get(a).getRobos().get(i).getX();
                    int newX;
                    if (a == 0){
                        newX = xjogador + rand.nextInt(3);
                    } else {
                        newX = xjogador - rand.nextInt(3);
                    }
                    if (newX > 19 || newX < 1){
                        newX = xjogadorbola;
                    }
                    jogo.getEquipas().get(a).getRobos().get(i).move(newX, jogo.getEquipas().get(a).getRobos().get(i).getX());
                    System.out.print("O jogador "+jogo.getEquipas().get(a).getRobos().get(i).getId()+" acompanhou-o para [" + newX + ", " + jogo.getEquipas().get(a).getRobos().get(i).getX() + "]. ");
                }
            }
        }
        System.out.println("");
        //mover os adversarios
        int e = 1-a;
        for (int i = 0; i < jogo.getEquipas().get(e).getRobos().size(); i++){
            if (jogo.getEquipas().get(e).getRobos().get(i).getTipoString() != "GuardaRedes"){
                int xjogadorE = jogo.getEquipas().get(e).getRobos().get(i).getX();
                int yjogadorE = jogo.getEquipas().get(e).getRobos().get(i).getY();
                int dxE = Math.abs(xjogadorE - newXbola);
                int dyE = Math.abs(yjogadorE - newY);
                int newXE, newYE;
                //mover no Y
                if (dyE == 0){
                    if (yjogadorE > 5){
                        newYE = 5 - rand.nextInt(2);
                    } else {
                        newYE = 5 + rand.nextInt(2);
                    }
                } else {
                    if (yjogadorE > 5){
                        newYE = yjogadorE - rand.nextInt(3);
                    } else {
                        newYE = yjogadorE + rand.nextInt(3);
                    }
                }
                //mover no X
                if (dxE != 0){
                    if (xjogadorE > newXbola){
                        newXE = xjogadorE - rand.nextInt(2);
                    } else {
                        newXE = xjogadorE + rand.nextInt(2);
                    }
                } else {
                    newXE = newXbola;
                }
                if (newXE > 19 || newXE < 1){
                    newXE = xjogadorE;
                }
                jogo.getEquipas().get(e).getRobos().get(i).move(newXE, newYE);
                System.out.print("O jogador adversário " + jogo.getEquipas().get(e).getRobos().get(i).getId() + " seguiu a bola para [" + newXE + ", " + newYE + "]. ");
            }
        }
        System.out.println("");
        jogo.addTempoDecorrido(rand.nextInt(7));
        System.out.println("");
    }
    public static void marcarGolo(){
        //Saber que equipa tem a bola
        int a = 0;
        for (int i = 0; i < jogo.getEquipas().get(1).getRobos().size(); i++){
            if (jogo.getEquipas().get(1).getRobos().get(i).getPosseBola() == true){
                a = 1;
            }
        }
        //Saber que jogador tem a bola (0 é apenas para iniciar)
        int indexjogadorbola = 0;
        for (int i = 0; i < jogo.getEquipas().get(a).getRobos().size(); i++){
            if (jogo.getEquipas().get(a).getRobos().get(i).getPosseBola() == true){
                indexjogadorbola = i;
            }
        }
        int e = 1-a;
        int xbaliza = (a == 0) ? 20 : 0;
        if ((xbaliza - jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).getX()) < 3){
            int chance = rand.nextInt(2);
            if (chance == 1){
                jogo.getBola().move(xbaliza, 5);
                jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).setPosseBola(false);
                jogo.getEquipas().get(a).marcarGolo();
                jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).addGolosMarcados();
                jogo.getEquipas().get(e).sofrerGolo();
                jogo.addTempoDecorrido(rand.nextInt(7));
                reiniciarJogo();
                System.out.println("A equipa " + jogo.getEquipas().get(a).getNome() + " marcou GOLO! SCORE: " + Integer.toString(jogo.getEquipas().get(0).getGolosMarcados()) + " | " + Integer.toString(jogo.getEquipas().get(1).getGolosMarcados()));
                System.out.println("");
            }  else {
                jogo.getBola().move(xbaliza, 5);
                jogo.getEquipas().get(a).getRobos().get(indexjogadorbola).setPosseBola(false);
                int index = rand.nextInt(3);
                jogo.getBola().move(jogo.getEquipas().get(e).getRobos().get(index).getX(), jogo.getEquipas().get(e).getRobos().get(index).getY());
                jogo.getEquipas().get(e).getRobos().get(index).setPosseBola(true);
                jogo.addTempoDecorrido(rand.nextInt(7));
                System.out.println("O guarda redes defendeu! E passou ao jogador " + jogo.getEquipas().get(e).getRobos().get(index).getId());
                System.out.println("");
            }
        }
    }
    public static void reiniciarJogo(){
        int[][] P = {{8,7},{7,5},{8,3},{0,5},{12,7},{12,5},{12,3},{20,5},{10,5}};
        int i = 0;
        for (int p = 0; p < jogo.getEquipas().get(0).getRobos().size(); p++){
            jogo.getEquipas().get(0).getRobos().get(p).move(P[i]);
            i++;
        }
        for (int p = 0; p < jogo.getEquipas().get(1).getRobos().size(); p++){
            jogo.getEquipas().get(1).getRobos().get(p).move(P[i]);
            i++;
        }
        jogo.getBola().setPosition(P[i]);
    }
}
