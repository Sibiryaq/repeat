package praktikum.OOP.school;

public class TestTeacher extends Teacher {

    @Override
    protected String startLesson() {
        return "Еврибади пучехэндсап. " +
                "Я использую Ctrl + O " +
                "для переопределения методов супер-класса";
    }
}
