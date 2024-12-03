public class LinkedList<T> {

    Node<T> head;

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.insert("T1");
        list.insert("T2");
        list.insert("T3");
        list.print();
        System.out.println("\n=============");
        list.remove("T1");
        list.print();
        System.out.println("\n=============");
        list.insert(2,"T5");
        list.print();
        System.out.println("\n=============");
        list.insert(3,"TEST");
        list.print();
    }

    public void insert(T data) {
        Node<T> new_node = new Node<>(data);

        if (head == null) {
            head = new_node;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public void insert(int index, T data) {
        Node<T> new_node = new Node<>(data);

        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        if (index == 0) {
            new_node.next = head;
            head = new_node;
            return;
        }

        int count = 0;
        Node<T> currentNode = head;

        while (currentNode != null && count < index - 1) {
            currentNode = currentNode.next;
            count++;
        }

        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        new_node.next = currentNode.next;
        currentNode.next = new_node;

    }


    public void remove(T data) {

        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;
        Node<T> prevNode = null;

        while (currentNode != null && !currentNode.data.equals(data)) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        prevNode.next = currentNode.next;


    }

    public void remove(int index) {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;
        int count = 0;

        while (currentNode != null && count < index - 1) {
            currentNode = currentNode.next;
            count++;
        }

        if (currentNode == null || currentNode.next == null) throw new IndexOutOfBoundsException("Index out of bounds");

        currentNode.next = currentNode.next.next;

    }

    public void print() {
        Node<T> currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T d) {
            this.data = d;
            this.next = null;
        }
    }


}