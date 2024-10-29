import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCycleDetection {

    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; 
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next;     
            if (slow == fast) {        
                return true;
            }
        }

        return false; 
    }

    public static Node buildLinkedListWithCycle(int numNodes, int cycleIndex) {
        if (numNodes <= 0) return null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the node values:");

        Node head = new Node(scanner.nextInt());
        Node current = head;
        Map<Integer, Node> nodesMap = new HashMap<>(); 
        nodesMap.put(0, head);

        for (int i = 1; i < numNodes; i++) {
            Node newNode = new Node(scanner.nextInt());
            current.next = newNode;
            current = newNode;
            nodesMap.put(i, newNode); 
        }

        if (cycleIndex >= 0 && cycleIndex < numNodes) {
            current.next = nodesMap.get(cycleIndex); 
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the linked list: ");
        int numNodes = scanner.nextInt();

        System.out.print("Enter the index of the node to start the cycle (-1 for no cycle): ");
        int cycleIndex = scanner.nextInt();

        Node head = buildLinkedListWithCycle(numNodes, cycleIndex);

        System.out.println("Does the linked list have a cycle? " + hasCycle(head));
    }
}
