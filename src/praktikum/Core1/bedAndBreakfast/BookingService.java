package praktikum.Core1.bedAndBreakfast;

public class BookingService {
    private int capacity = 10;
    private boolean full = false;

    public void book() {
        if (!full) {
            System.out.println("Забронирован еще один номер");
            capacity++;
            printRooms();
            if (capacity == 0) {
                full = true;
            }
        } else {
            System.out.println("Свободных номеров нет!");
        }
    }

    public void printRooms() {
        System.out.println("Свободных номеров - " + capacity);
    }

    public void free() {
        if (capacity < 10) {
            capacity++;
            System.out.println("Освободился номер!");
            printRooms();
            full = false;
        } else {
            System.out.println("В гостинице только 10 номеров.");
        }
    }

    public boolean isFull() {
        return full;
    }
}
