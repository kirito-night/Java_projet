public class TestSimulation {
    public static void main(String[] args) {
<<<<<<< HEAD
        Simulation s1 = new Simulation(4, 5 , 100, 20);
=======
        Simulation s1 = new Simulation(10, 11, 100, 20);
>>>>>>> ad3afb05a4fdbb8d892b2842066b5da9d40fdaad
        for (int i = 0; i < 10; i++) {
            s1.agentsAction();
            s1.moveAgents();
            Outils.ressourceResume();
            Outils.afficherSeparateur();
        }
        
    }
}
