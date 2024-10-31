package praktikum.sp6.managers;

import praktikum.sp6.tasks.Task;

public class Node<T extends Task> {
    private final Task data;
    private Node<T> prev;
    private Node<T> next;

    public Task getData() {
        return data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }


    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node(Task data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
