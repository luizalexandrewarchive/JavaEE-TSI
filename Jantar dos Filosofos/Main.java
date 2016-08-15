
public class Main {

	public static void main(String[] args) {

                //Criando os garfos passando os nomes
		Garfo[] garfos = {
                        new Garfo("Garfo 1"),
                        new Garfo("Garfo 2"),
                        new Garfo("Garfo 3"),
                        new Garfo("Garfo 4"),
                        new Garfo("Garfo 5")
                };

                //Criando os filosofos e passando quais garfos ele pode pegar
                //EX: Filosofo 3 pode usar somente o GARFO_1 e GARFO_2
                Filosofo[] filosofos = {
                        new Filosofo(Filosofo.FILOSOFO_1, Garfo.GARFO_4, Garfo.GARFO_0),
                        new Filosofo(Filosofo.FILOSOFO_2, Garfo.GARFO_0, Garfo.GARFO_1),
                        new Filosofo(Filosofo.FILOSOFO_3, Garfo.GARFO_1, Garfo.GARFO_2),
                        new Filosofo(Filosofo.FILOSOFO_4, Garfo.GARFO_2, Garfo.GARFO_3),
                        new Filosofo(Filosofo.FILOSOFO_5, Garfo.GARFO_3, Garfo.GARFO_4),
                };

                //Atribui os garfos criados anteriormente os filosofos
                Filosofo.garfos = garfos;

                //inicia as Threads
                filosofos[0].start();
                filosofos[1].start();
                filosofos[2].start();
                filosofos[3].start();
                filosofos[4].start();
        
	}

}
