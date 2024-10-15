package praktikum.OOP.school;

public class GymTeacher extends Teacher{

    @Override
    protected String startLesson() {
        super.startLesson();
        return "Стройтесь по росту!";

    }
}
