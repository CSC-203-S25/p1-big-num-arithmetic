public class LinkedList { //Double Linked List
    Node head;
    private Node tail;
    int length;
    //Create Nodes for linked list
    public static class Node {
        Node next;
        Node prev;
        int data;

        Node(int data) { //Node Constructor
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public LinkedList (String number) { //Linked List Constructor 1
        char[] numberArray = number.toCharArray();

        // 0 is the highest digit, length - 1 is the lowest
        this.head = null;
        this.tail = null;
        // stored in reverse order
        for (int i = numberArray.length - 1; i >= 0; i--) {
            Node node = new Node(Character.getNumericValue(numberArray[i]));

            this.appendToList(node);
        }

    }
    public LinkedList () { //Linked List Constructor 1
        this.head = null;
        this.tail = null;
    }

    public String toString() { // stored in reverse order
        Node node = this.tail;
        String result = "";
        while (node != null) {
            result += node.data + "";
            node = node.prev;
        }
        return  result;
    }



    public void appendToList(Node node) { //Append to List
        if (this.head == null) {
            this.head = node;
            this.tail=node;
            node.prev = null;
        } else {
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
        }
        this.length++;
    }
    public static LinkedList addition(LinkedList list1, LinkedList list2) { //Addition Method
        //Create an int for when the result is over 9
        int carry = 0;
        Node currentA = list1.head;
        Node currentB = list2.head;
        LinkedList result = new LinkedList();
        while (currentA != null || currentB != null) {
            int digitA = (currentA != null) ? currentA.data : 0;
            int digitB = (currentB != null) ? currentB.data : 0;

            int sum = digitA + digitB + carry;
            int digit = sum % 10; // result
            carry = sum / 10; // carry either a 0 or 1

            result.appendToList(new Node(digit));

            if (currentA != null) currentA = currentA.next;
            if (currentB != null) currentB = currentB.next;
        }

        if (carry > 0) {
            result.appendToList(new Node(carry));
        }

        return result;
    }

    public static LinkedList mult(LinkedList list1, LinkedList list2) { //Multiplication Method
        if (list1.head == null && list2.head == null) {
            return null;
        }
        if (list1.head == null) {
            return list2;
        }
        if (list2.head == null) {
            return list1;
        }

        //Amount of digits is expected for the result
        int[] resultDigits = new int[list1.length + list2.length];

        int i = 0;
        for (LinkedList.Node a = list1.head; a != null; a = a.next) {
            int j = 0;
            for (LinkedList.Node b = list2.head; b != null; b = b.next) {
                resultDigits[i + j] += a.data * b.data;
                j++;
            }
            i++;
        }

        //Account for carries
        for (int k = 0; k < resultDigits.length; k++) {
            int carry = resultDigits[k] / 10;
            resultDigits[k] %= 10;
            if (k + 1 < resultDigits.length) {
                //Goes to the right since the lists are reversed
                resultDigits[k + 1] += carry;
            }
        }

        // Remove any extra leading zeros
        int resultLength = resultDigits.length;
        while (resultLength > 1 && resultDigits[resultLength - 1] == 0) {
            resultLength--;
        }

        // Build the result linked list
        LinkedList result = new LinkedList();
        for (int k = 0; k < resultLength; k++) {
            result.appendToList(new LinkedList.Node(resultDigits[k]));
        }

        return result;
    }

    public static LinkedList expo(LinkedList base, LinkedList exponent) { //Exponential Method
        if (base.head == null || exponent.head == null) {
            return base;
        }

        // If exponent is zero (a single-node with 0), return 1.
        if (exponent.length == 1 && exponent.head.data == 0) {
            return new LinkedList("1");
        }

        LinkedList result = new LinkedList();

        // Main loop: repeat until exponent becomes zero.
        while (exponent.length > 1 || exponent.head.data != 0) {
            // If exponent is odd, multiply result by base.
            if (exponent.head.data % 2 != 0) {
                result = mult(result, base);
            }

            // Square the base
            base = mult(base, base);

            // Exponentiation by squares
            // Convert the reversed exponent into normal order by traversing from tail to head,
            // then perform long division digit-by-digit, then convert back to reversed order.
            LinkedList quotientNormal = new LinkedList();  // will hold quotient in normal order
            int rem = 0;
            for (LinkedList.Node node = exponent.tail; node != null; node = node.prev) {
                int cur = rem * 10 + node.data;
                int q = cur / 2;
                rem = cur % 2;
                quotientNormal.appendToList(new LinkedList.Node(q));
            }
            //Remove any leading zeros in normal order
            while (quotientNormal.head.data == 0 && quotientNormal.length > 1) {
                quotientNormal.head = quotientNormal.head.next;
                quotientNormal.length--;

                quotientNormal.head.prev = null;

            }
            // Convert quotientNormal in normal order back to reversed order
            LinkedList newExp = new LinkedList();
            for (LinkedList.Node node = quotientNormal.tail; node != null; node = node.prev) {
                newExp.appendToList(new LinkedList.Node(node.data));
            }
            exponent = newExp;
        }

        return result;
    }


}