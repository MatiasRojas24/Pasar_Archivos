package EjercicioProcesos1;
import java.lang.Thread;
public class Procesos extends Thread{
    public int id;

    public Procesos(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Soy el proceso: "+this.getName()+" de ID: "+id);
    }
}
