package praktikum.sp6.managers;

import praktikum.sp6.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryManager implements HistoryManager {

    private Node head;
    private Node tail;
    private Map<Integer, Node> history = new HashMap<>();

    @Override
    public void add(Task task) {
        Node node = history.get(task.getId());
        if (history.containsValue(node)) {
            removeNode(node);
        }
        Node newNode = new Node(task);
        linkLast(newNode);
        history.put(task.getId(), newNode);
    }

    @Override
    public void remove(int id) {
        Node node = history.get(id);
        if (node != null) {
            removeNode(node);
            history.remove(id);
        }
    }


    private void linkLast(Node node) {
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> arrayHistory = new ArrayList<>();
        Node n = head;
        while (n != null) {
            arrayHistory.add(n.getData());
            n = n.getNext();
        }

        return arrayHistory;

    }

    public void removeNode(Node node) {
        history.remove(node.getData().getId());
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }

    }

}