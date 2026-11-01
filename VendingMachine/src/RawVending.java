public class RawVending {
    private enum  State {
        IDLE,
        ITEM_SELECTED,
        HAS_MONEY,
        DISPENSING
    }
    private State currentState=State.IDLE;
    private String selectedItem="";
    private double insertedAmount=0.0;
    public void selectItem(String item){
        switch (currentState){
            case IDLE:
                currentState=State.ITEM_SELECTED;
                selectedItem=item;
                break;
            case ITEM_SELECTED:
                System.out.println("item already seelcted ");
                break;
            case HAS_MONEY:
                System.out.println("already has money ");
            case DISPENSING:
                System.out.println("item is already dispensing");
        }
    }
    public void insertMoney(double money){
        switch (currentState){
            case IDLE:
                System.out.println("no item selected");
                break;
            case ITEM_SELECTED:
                insertedAmount=money;
                currentState=State.HAS_MONEY;
                break;
            case HAS_MONEY:
                System.out.println("already has money ");
            case DISPENSING:
                System.out.println("item is already dispensing");
        }
    }
    public void dispenseItem(){
        switch (currentState){
            case IDLE:
                System.out.println("no item selected");
                break;
            case ITEM_SELECTED:
                System.out.println("item already seelcted ");
                break;
            case HAS_MONEY:
                currentState=State.DISPENSING;
                System.out.println("dispensing slected item"+selectedItem);
                resetState();
                break;
            case DISPENSING:
                System.out.println("item is already dispensing");
        }
    }
    private void resetState(){
        currentState=State.IDLE;
        selectedItem="";
        insertedAmount=0.0;
    }
}
