public class TestSimulation {
    public static void main(String[] args) {
        // Simulation s1 = new Simulation(10, 10 ,80, 80);
        Simulation s1 = new Simulation(10, 10 , 5, 5);
        for (int i = 0; i < 10; i++) {
            s1.agentsAction();
        }
        
    }
}
