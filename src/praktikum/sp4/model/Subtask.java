package praktikum.sp4.model;

public class Subtask extends Task {
    private int idEpic;

    public Subtask(String title, String description, int idEpic) {
        super(title, description);
        this.idEpic = idEpic;
    }

    public int getIdEpic() {
        return idEpic;
    }

    public void setIdEpic(int idEpic) {
        this.idEpic = idEpic;
    }

    @Override
    public String toString() {
        return "ID подзадачи Subtask=\"" + id
                + "\", Название подзадачи=\"" + name
                + "\", Описание=\"" + description
                + "\", ID эпика=\"" + idEpic
                + "\", Статус=\"" + taskStatus + "\"";

    }

}
