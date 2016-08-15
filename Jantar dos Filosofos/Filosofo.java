
public class Filosofo extends Thread {
	
    public static final String FILOSOFO_1 = "Tales de Mileto";
    public static final String FILOSOFO_2 = "Anaximandro de Mileto";
    public static final String FILOSOFO_3 = "Anaxímenes de Mileto";
    public static final String FILOSOFO_4 = "Pitágoras";
    public static final String FILOSOFO_5 = "Xenófanes de Colófon";

    //Tempo que o filosofo vai ficar ocioso ou meditando depois de comer
    private static final int OCIOSO = 1000;

    public static Garfo[] garfos;

    private int usaGarfo1, usaGarfo2;

    public Filosofo(String name, int usagarfo1, int usaGarfo2) {
        super(name);

        //Define qual garfo o Filosofo pode usar
        //EX: Filosofo 3 pode usar somente o GARFO_1 e GARFO_2
        this.usaGarfo1 = usagarfo1;
        this.usaGarfo2 = usaGarfo2;
    }

    @Override
    public void run() {

        //Loop infinito para sempre ficar rodando
        while (true) {
        	
            //Inicia o loop com o filosofo com fome
        	System.out.println(getName() + " tem fome... ");
        	
            //Chama o metodo disponibilidade() para verificar se tem garfos disponíveis
            if (disponibilidade()) {    
            	
                //sendo disponível o filosofo come
                System.out.print("O filosodo " + getName() + " pegou " + garfos[usaGarfo1].getNome() + " e " + garfos[usaGarfo2].getNome() + ". E começou a comer...\n");

                //Come pelo tempo definido
                Thread.sleep(OCIOSO);
                //Libera os garfos para serem usados por outros filosofos
                garfos[usaGarfo1].release();
                garfos[usaGarfo2].release();
                //Começa a meditar
                meditar(OCIOSO);
                
            }
        }
    } 

    //recebe o tempo que vai meditar e para a Thread neste periodo
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
            //tenta adquirir a licença para usar este semaforo
            garfos[usaGarfo1].acquire();
            garfos[usaGarfo2].acquire();

            //verifica disponivilidade neste semáforo
            if(garfos[usaGarfo1].availablePermits() == 0 && garfos[usaGarfo2].availablePermits() == 0) {
                //returnando true os dois garfos estão disponíveis para uso
                return true;
            }

        }catch (InterruptedException e) {
        	System.out.println("[ERROR]: " + e);
        }

        return false;
    }
}