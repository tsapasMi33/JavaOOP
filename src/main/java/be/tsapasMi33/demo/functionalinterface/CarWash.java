package be.tsapasMi33.demo.functionalinterface;

import java.util.ArrayList;
import java.util.List;

public class CarWash {

    private List<CarWashHelper> commands;

    public CarWash() {
        this.commands = new ArrayList<>();
//        commands.add(c -> System.out.println("Preparing car #" + c.getNumber()));
//        commands.add(c -> wash(c));
//        commands.add(this::finish);
    }

    public void addService(CarWashHelper carWashHelper) {
        commands.add(carWashHelper);
    }

    private void prepare(Car c){
        System.out.println("Preparing car #" + c.getNumber());
    }

    private void wash(Car c) {
        System.out.println("Washing car #" + c.getNumber());
    }

    private void finish(Car c) {
        System.out.println("Finishing car #" + c.getNumber());
    }

    public void startTreatment(Car c){
        for (CarWashHelper f : commands) {
            f.execute(c);
        }
    }
}
