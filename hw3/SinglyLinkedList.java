//package hw3;

public class SinglyLinkedList {
    Node head;
    String listName;

    public SinglyLinkedList(String name) {
        this.listName = name;
        this.head = null;
    }

    // alomost done
    public void popBack() {
        if (isEmpty()) {
            System.out.println("ERROR"); // done
        } else if (head.next == null) { // only
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null; // จากชี้ตัวอื่นไป null แทน
        }

    }

    // done
    public void popFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            head = head.next; // ข้ามไปชี้ตัวถัดไปเลย
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
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }
    }

    // done right
    public void pushFront(Node node) {
        if (isEmpty()) {
            head = node; // ให้ head ชี้ได้เลย
        } else {
            node.next = head; // node ไปชี้ที่ head ชี้
            head = node; // เปลี่ยน head ชี้ node แทน
        }
    }

    // done
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head; // ให้ current อยู่ที่ตัวแรก
            while (current.next != null) {
                current = current.next; // ขยับถัดไป
            }
            current.next = node; // เอา node ไปต่อ

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
                return current;
            }
            while (current.next != null) {
                if (current.next.student_id == id) {
                    temp = current.next;
                    current.next = current.next.next;
                    return temp;
                }
                current = current.next;
            }
        }
        return new Node("Student Not Found!");
    }

    public void addNodeAfter(Node node1, Node node2) {
        node2.next = node1.next;
        node1.next = node2;

    }

    public void addNodeBefore(Node node1, Node node2) {
        if (isEmpty()) { // asdasd
            pushFront(node2);
        } else {

            Node current = head;
            if (node1 == head) {
                node2.next = node1;
                head = node2;
            }
            while (current.next != null) {
                if (current.next == node1) {
                    current.next = node2;
                    node2.next = node1;
                    return;
                }
                current = current.next;
            }

        }

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
        // return head == null;

    }

    // tester ไม่แน่ใจว่าต้อง check empty ไหม (list1 and 2)
    public void merge(SinglyLinkedList list) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }

    // done
    public void printStructure() {
        System.out.print(listName + ": head -> ");
        Node current = head;
        while (current != null) {
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next;
        }
        System.out.println("null");

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

            // return new Node(top.student_id, top.name, top.gpa);
        }
    }
}
