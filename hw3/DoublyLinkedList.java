package hw3;

//pop push back to O(1)
public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;

    public DoublyLinkedList(String name) {
        this.listName = name;
        this.head = null;
        this.tail = null;
    }

    public void popBack() {
        if (isEmpty()) {
            System.out.println("ERROR"); // done
        } else if (head.next == null) { // have only 1
            // ให้ทั้งคู้ชี้ null
            head = null;
            tail = null;
        } else {
            tail = tail.previous; // ให้ tail ไปชี้ตัวก่อนสุดท้าย
            tail.next = null; // จากนั้นให้ตัดขาดกับตัวเมื่อกี้ไปเลย

        }

    }

    public void popFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            head = head.next;
        }
    }

    public Node topFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return new Node(head.student_id, head.name, head.gpa);
            // return head;
        }
    }

    public Node topBack() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return new Node(tail.student_id, tail.name, tail.gpa);
            // return tail;
        }
    }

    public void pushFront(Node node) {
        if (isEmpty()) { // if true
            // ทั้งคู่ชี้ที่ node
            head = node;
            tail = node;
        } else {
            node.next = head; /// ให้ตัวที่เราจะใส่ชี้ที่เดียวกับ head
            head.previous = node;
            head = node;

            // เปลี่ยน head ไปชี้ node แทน

        }
    }

    public void pushBack(Node node) {
        if (isEmpty()) {
            // ให้ทั้งคู้ชี้ node เนื่องจากก็มีแค่ตัวเดียว
            head = node;
            tail = node;
        } else {
            tail.next = node; // เหมือนว่าให้ชี้ต่อ เพราะเราเอาไปต่ออะ
            node.previous = tail; // ต้องเชื่อมกับก่อนหน้าด้วย เดี๋ยวขบวนขาด
            tail = node; // ให้ tail ไปหลังสุด

        }
    }

    public Node findNode(int id) {
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) {
                if (current.student_id == id) {
                    return current;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");

        }
    }

    public Node eraseNode(int id) {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node temp;
            if (current.student_id == id) {
                head = current.next;
                current.next.previous = head;
                return current;
            }
            if (tail.student_id == id) {
                temp = tail;
                popBack();
                return temp;
            }
            while (current.next != null) {
                if (current.next.student_id == id) {
                    temp = current.next;
                    current.next = current.next.next; // fix this and done
                    current.next.previous = current; // cuurent.next = .next.next
                    return temp;

                }
                current = current.next;
            }

            return new Node("Student Not Found!");
        }
    }

    public void addNodeAfter(Node node1, Node node2) {
        if (node1 == tail) {
            tail = node2;
        }
        node2.next = node1.next;
        node1.next = node2;
        node2.previous = node1;

    }

    public void addNodeBefore(Node node1, Node node2) {
        if (isEmpty() || head == node1) {
            pushFront(node2);
        } else {
            // Node current = head;
            // while (current.next != null) {
            // if (current.next == node1) {
            // node2.next = node1;
            // node1.previous = node2;
            // current.next = node2;
            // node2.previous = current;
            // return;

            // }
            // current = current.next;
            // }
            node2.next = node1;
            node2.previous = node1.previous;
            node1.previous.next = node2;
            node1.previous = node2;

        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }

    }

    // done
    public void merge(DoublyLinkedList list) {
        if (list.isEmpty()) {
            return; // ไม่ต้อง merge
        }
        if (isEmpty()) {
            // ให้ head and tail เป็นของ list ไปเลย
            head = list.head;
            tail = list.tail;
            return;
        }
        // กรณีปกติ
        tail.next = list.head; // อันสุดท้ายไปชี้ต่อที่ตัวแรกของ list
        list.head.previous = tail;// อันแรกของlist กลับมาชี้สุดท้ายอันแรก
        tail = list.tail; // ขยับ tail ไปหลังสุด
    }

    public void printStructure() {

        // inspir from print backward
        Node current = head;
        System.out.print(listName + ": head <-> ");
        while (current != null) {
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }

    // This may be useful for you for implementing printStructure()
    public void printStructureBackward() {
        Node current = tail;
        System.out.print(listName + ": tail <-> ");
        while (current != null) {
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }

    public Node whoGotHighestGPA() {
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head.next;
            Node top = head;
            while (current != null) {
                if (current.gpa >= top.gpa) {
                    top = current;
                }
                current = current.next;

            }
            return top;
        }
    }
}
