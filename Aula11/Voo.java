package Aula11;

public class Voo {
    String 
        hora,
        voo,
        companhia,
        origem,
        atraso,
        obs
    ;

    //Hora  Voo Companhia   Origem  Atraso  Obs
    public Voo(String hora, String voo, String companhia, String origem, String atraso){
        this.hora = hora;
        this.voo = voo;
        this.companhia = companhia;
        this.origem = origem;
        this.atraso = atraso;
        String[] horaSplit = this.hora.split("\\W");
        String[] atrasoSplit = this.atraso.split("\\W");
        int horaInt = Integer.parseInt(atrasoSplit[0])*60+Integer.parseInt(atrasoSplit[1]);
        int atrasoInt = Integer.parseInt(horaSplit[0])*60+Integer.parseInt(horaSplit[1]);
        int total = horaInt + atrasoInt;
        if((int)total/60 < 10){
            if (total%60 < 10){
                this.obs = "0"+Integer.toString((int)total/60)+":0"+Integer.toString(total%60);
            } else {
                this.obs = "0"+Integer.toString((int)total/60)+":"+Integer.toString(total%60);
            }
            
        } else{
            if (total%60 < 10){
                this.obs = Integer.toString((int)total/60)+":0"+Integer.toString(total%60);
            } else {
                this.obs = Integer.toString((int)total/60)+":"+Integer.toString(total%60);
            }
        }
    }
    public Voo(String hora, String voo, String companhia, String origem){
        this.hora = hora;
        this.voo = voo;
        this.companhia = companhia;
        this.origem = origem;
        this.atraso = "";
        this.obs = "";
    }

    public String getAtraso() {
        return atraso;
    }
    public String getCompanhia() {
        return companhia;
    }
    public String getHora() {
        return hora;
    }
    public String getObs() {
        return obs;
    }
    public String getOrigem() {
        return origem;
    }
    public String getVoo() {
        return voo;
    }

}
