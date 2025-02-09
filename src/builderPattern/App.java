package builderPattern;

public class App {

    public Truck buy() {
        return Truck.builder()
                .owner("ООО Перевозочка")
                .stsNumber("123 123123123")
                .year(2022)
                .build();
    }


    public Truck buyAvito() {
        return Truck.builder()
                .owner("ООО Перевозочка")
                .stsNumber("123 123123123")
                .year(2022)
                .driver("Иванов")
                .build();
    }

    public Truck send() {
        return Truck.builder()
                .owner("ООО Перевозочка")
                .stsNumber("123 123123123")
                .year(2022)
                .driver("Иванов")
                .loadCapacity(20000)
                .build();
    }
}
