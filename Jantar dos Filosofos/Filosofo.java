
public class Filosofo extends Thread {
	
    public static final String FILOSOFO_1 = "Tales de Mileto";
    public static final String FILOSOFO_2 = "Anaximandro de Mileto";
    public static final String FILOSOFO_3 = "Anaxímenes de Mileto";
    public static final String FILOSOFO_4 = "Pitágoras";
    public static final String FILOSOFO_5 = "Xenófanes de Colófon";

    private static final int OCIOSO = 1000;

    public static Garfo[] garfos;

    private int usaGarfo1, usaGarfo2;

    public Filosofo(String name, int usagarfo1, int usaGarfo2) {
        super(name);
        this.usaGarfo1 = usagarfo1;
        this.usaGarfo2 = usaGarfo2;
    }

    @Override
    public void run() {

        while (true) {
        	
        	System.out.println(getName() + " tem fome... ");
        	
            if (disponibilidade()) {    
            	
                System.out.print("O filosodo " + getName() + " pegou " + garfos[usaGarfo1].getNome() + " e " + garfos[usaGarfo2].getNome() + ". E começou a comer...\n");

                meditar(OCIOSO);
                garfos[usaGarfo1].release();
                garfos[usaGarfo2].release();
                meditar(OCIOSO);
                
            }
        }
    } 

    private void meditar(int time) {
        try {
        	System.out.println("O filosofo " + getName() + " começa a meditar");
            Thread.sleep(time);
        }catch (InterruptedException e) {
        	System.out.println("[ERROR]: " + e);
        }
    }
    
    private boolean disponibilidade(){
        try {
            garfos[usaGarfo1].acquire();
            garfos[usaGarfo2].acquire();
            if(garfos[usaGarfo1].availablePermits() == 0 && garfos[usaGarfo2].availablePermits() == 0) {
                return true;
            }

        }catch (InterruptedException e) {
        	System.out.println("[ERROR]: " + e);
        }

        return false;
    }
}