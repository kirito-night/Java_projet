public class TestSimulation {
    public static void main(String[] args) {
        Simulation s1 = new Simulation(10, 10 , 100, 20);
        for (int i = 0; i < 10; i++) {
            s1.agentsAction();
            s1.moveAgents();
            s1.ressourceResume();
        }
        
    }
}
