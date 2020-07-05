import java.util.Arrays;

public class TwoDirectionalLinkedList implements TwoDirectionalList {

    private Node first;
    private Node last;
    private int size = 0;
    private int sizeThresholdForMultiThreads = 1000; //чем больше, тем эффективнее
    private Node nodeToDelete;

    private SearchLeftToRight searchLeftToRight;
    private SearchRightToLeft searchRightToLeft;
    private Thread threadForSearchNodeToDeleteLeftToRight;
    private Thread threadForSearchNodeToDeleteRightToLeft;

    public TwoDirectionalLinkedList(){
    }

    public TwoDirectionalLinkedList(String[] strArr){

        for (int i = 0; i < strArr.length; i++){
            add(strArr[i]);
        }
    }

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val, null, null);
            last = first;
            size++;
            return;
        }
        add(val, first);
    }

    private void add(String val, Node current) {
        if (current.getNext() == null) {
            current.setNext(new Node(val, null, current));
            last = current.getNext();
            size++;
        } else {
            add(val, current.getNext());
        }
    }

    @Override
    public boolean remove(String val) {

            if (first.getVal().equals(val)) {
                if (first.getNext() == null) {
                    first = null;
                    last = null;
                } else {
                    first = first.getNext();
                    first.setPrevious(null);
                }
                size--;
                return true;
            }

        if(size < sizeThresholdForMultiThreads) {
            Node current = first.getNext();
            Node prev = first;

            while (current != null) {
                if (current.getVal().equals(val)) {
                    prev.setNext(current.getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrevious(prev);
                    } else last = prev;
                    size--;
                    return true;
                } else {
                    prev = current;
                    current = current.getNext();
                }
            }
            return false;

        } else{
            searchLeftToRight = new SearchLeftToRight(this, val);
            searchRightToLeft = new SearchRightToLeft(this, val);

            threadForSearchNodeToDeleteLeftToRight = new Thread(searchLeftToRight);
            threadForSearchNodeToDeleteRightToLeft = new Thread(searchRightToLeft);

            threadForSearchNodeToDeleteRightToLeft.start();
            threadForSearchNodeToDeleteLeftToRight.start();

            try {
                threadForSearchNodeToDeleteLeftToRight.join();
                threadForSearchNodeToDeleteRightToLeft.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(nodeToDelete != null){
                Node current = nodeToDelete;
                Node prev = nodeToDelete.getPrevious();

                prev.setNext(current.getNext());
                if (current.getNext() != null) {
                    current.getNext().setPrevious(prev);
                } else last = prev;
                size--;
                nodeToDelete = null;

                return true;
            }

            return false;
        }
    }

    public SearchLeftToRight getSearchLeftToRight() {
        return searchLeftToRight;
    }

    public SearchRightToLeft getSearchRightToLeft() {
        return searchRightToLeft;
    }

    public Thread getThreadForSearchNodeToDeleteLeftToRight() {
        return threadForSearchNodeToDeleteLeftToRight;
    }

    public Thread getThreadForSearchNodeToDeleteRightToLeft() {
        return threadForSearchNodeToDeleteRightToLeft;
    }

    @Override
    public Node getFirst() {
        return first;
    }

    @Override
    public Node getLast() {
        return last;
    }

    public void setNodeToDelete(Node nodeToDelete){
        this.nodeToDelete = nodeToDelete;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        Node current = first;
        Object[] arr = new Object[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = current.getVal();
            current = current.getNext();
        }
        return Arrays.toString(arr);
    }

    public class Node {
        private String val;
        private Node next;
        private Node previous;

        public Node(String val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }

        public String getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

}
