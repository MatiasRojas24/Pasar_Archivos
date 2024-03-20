package EjercicioProcesos1;
import java.util.List;
public class MainEjercicio2 {
    public static void main(String[] args) {
        Procesos[] procesos = new Procesos[5];
        for (int i = 0; i < 5; i++){
            procesos[i] = new Procesos("Proceso "+i,i);
            procesos[i].start();
            try{
                procesos[i].join();
            }catch(Exception E){}
        }

    }
}
