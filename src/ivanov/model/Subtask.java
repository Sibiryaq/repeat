package ivanov.model;

public class Subtask extends Task {
    Epic epic;

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    @Override
    public TaskType getType() {
        return TaskType.SUBTASK;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", startTime="+ getStartTime() + '\'' +
                ", duration="+ getDuration() + '\'' +
                ", endTime=" + getEndTime() +
                ", epic=" + getEpic() +
                '}';
    }
}
