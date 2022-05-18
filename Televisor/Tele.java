package Televisor;

public class Tele {
    private boolean estado;
    private int canal;
    private int volumen;

    public Tele(){
        estado = false;
        volumen = 0;
        canal = 1;
    //Falta el soporte, porque si ya se usan siguen marcandose como que no en la clase
    }
    public Tele encender(){
        estado = true;
        return this;
    //Hay va el objeto o la clase ?
    }
    public Tele apagar(){
        estado = false;
        return this;
    }
    public Tele SubirVolumen(){
        if (estado){
            volumen = Math.min(volumen +1, 30);
        }
        return this;
    }
    public Tele BajarVolumen(){
        if (estado){
            volumen = Math.max(volumen -1, 0);
        }
        return this;
        //Hacerlo de otra forma con IF 
    }
    public int getCanal(){
        return canal;
    }
    public int getVolumen(){
        return volumen;
    }
    public Tele sintonizarCanal(int canal){
        if(estado && canal<100 && canal>0){
            this.canal = canal;
        }
        return this;
    }
}
