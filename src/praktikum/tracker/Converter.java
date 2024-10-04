package praktikum.tracker;

public class Converter {
    double oneStep;
    int oneStepCalories;

    public Converter(double oneStep, int oneStepCalories) {
        this.oneStep = oneStep;
        this.oneStepCalories = oneStepCalories;

    }

    double convertStepsInKm(int stepsTotal) {
        return stepsTotal * oneStep / 100000;
    }

    int convertCalories(int stepsTotal) {
        return stepsTotal * oneStepCalories / 1000;
    }
}
