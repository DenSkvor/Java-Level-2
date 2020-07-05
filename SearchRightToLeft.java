public class SearchRightToLeft implements Runnable {

    //<--

    private TwoDirectionalLinkedList twoDirectionalLinkedList;
    private Object valToDelete;
    private int halfSize;
    private int iter = 0;

    public SearchRightToLeft(TwoDirectionalLinkedList twoDirectionalLinkedList, Object valToDelete){
        this.twoDirectionalLinkedList = twoDirectionalLinkedList;
        this.valToDelete = valToDelete;

        if((twoDirectionalLinkedList.size()-1)%2 == 0) halfSize = (twoDirectionalLinkedList.size()-1)/2;
        else halfSize = (twoDirectionalLinkedList.size()-1)/2 + 1;
    }

    public int getIterAndHalfSizeComparsion() {
        return halfSize - iter;
    }

    @Override
    public void run() {

        TwoDirectionalLinkedList.Node current = twoDirectionalLinkedList.getLast();
        for (int i = 1; i <= halfSize; i++){
            //System.out.println(current.getVal());
            if(current.getVal().equals(valToDelete)) {
                twoDirectionalLinkedList.setNodeToDelete(current);
                //System.out.println(current.getVal() + "<--");
                break;
            }

            if ((!twoDirectionalLinkedList.getThreadForSearchNodeToDeleteLeftToRight().isAlive())
                    && twoDirectionalLinkedList.getSearchLeftToRight().getIterAndHalfSizeComparsion() > 0) {
                //System.out.println("1 stoped");
                break;
            }

            current = current.getPrevious();
            iter++;
        }

    }
}
