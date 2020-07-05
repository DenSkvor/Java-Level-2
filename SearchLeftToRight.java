public class SearchLeftToRight implements Runnable {

    //-->

    private TwoDirectionalLinkedList twoDirectionalLinkedList;
    private Object valToDelete;
    private int halfSize;
    private int iter = 0;

    public SearchLeftToRight(TwoDirectionalLinkedList twoDirectionalLinkedList, Object valToDelete){
        this.twoDirectionalLinkedList = twoDirectionalLinkedList;
        this.valToDelete = valToDelete;
        halfSize = (twoDirectionalLinkedList.size()-1)/2;
    }

    public int getIterAndHalfSizeComparsion() {
        return halfSize - iter;
    }

    @Override
    public void run() {

        TwoDirectionalLinkedList.Node current = twoDirectionalLinkedList.getFirst().getNext();
        for (int i = 1; i <= halfSize; i++){
            //System.out.println(current.getVal());
            if(current.getVal().equals(valToDelete)) {
                twoDirectionalLinkedList.setNodeToDelete(current);
                //System.out.println(current.getVal() + "<--");
                break;
            }

            if((!twoDirectionalLinkedList.getThreadForSearchNodeToDeleteRightToLeft().isAlive())
                    && twoDirectionalLinkedList.getSearchRightToLeft().getIterAndHalfSizeComparsion() > 0) {
                //System.out.println("2 stoped");
                break;
            }

            current = current.getNext();
            iter++;
        }

    }
}
