public class TestSimulation {
    public static void main(String[] args) {
        Simulation s1 = new Simulation(4, 5 , 100, 20);
        for (int i = 0; i < 10; i++) {
            s1.agentsAction();
            s1.moveAgents();
            Outils.ressourceResume();
            Outils.afficherSeparateur();
        }
        
    }
}
