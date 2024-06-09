import org.w3c.dom.Node;

public class DoubleLinkedList18 {
    Node18 head;
    int size;

    public DoubleLinkedList18() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item, int jarak) {
        if (isEmpty()) {
            head = new Node18(null, item, jarak, null);
        } else {
            Node18 newNode18 = new Node18(null, item, jarak, head);
            head.prev = newNode18;
            head = newNode18;
        }
        size++;
    }

    public void addLast(int item, int jarak) {
        if (isEmpty()) {
            addFirst(item, jarak);
        } else {
            Node18 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node18 newNode18 = new Node18(current, item, jarak, null);
            current.next = newNode18;
            size++;
        }
    }

    public void add(int item, int jarak, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Index out of bounds.");
        } else if (index == 0) {
            addFirst(item, jarak);
        } else if (index == size) {
            addLast(item, jarak);
        } else {
            Node18 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node18 newNode18 = new Node18(current.prev, item, jarak, current);
            current.prev.next = newNode18;
            current.prev = newNode18;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node18 tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + " (" + tmp.jarak + ")\t");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list is empty, cannot remove!");
        } else if (size == 1) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list is empty, cannot remove!");
        } else if (size == 1) {
            head = null;
        } else {
            Node18 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.prev.next = null;
        }
        size--;
    }

    public void remove(int index) {
        Node18 current = head;
        while (current != null) {
            if (current.data == index) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public int getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List is empty.");
        }
        return head.data;
    }

    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List is empty.");
        }
        Node18 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public Integer get(int index) {
        if (index >= size || index < 0) {
            return null; // return null if index is out of bounds
        }
        Node18 current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return null; // return null if index is not found
    }

    public Integer getJarak(int index) {
        if (index >= size || index < 0) {
            return null; // return null if index is out of bounds
        }
        Node18 current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.jarak;
            }
            count++;
            current = current.next;
        }
        return null; // return null if index is not found
    }
}
