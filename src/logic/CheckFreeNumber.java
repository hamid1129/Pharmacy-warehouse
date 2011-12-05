package logic;

/**
 *
 * @author hamid
 */
public class CheckFreeNumber {

    int numOfBoxes;

    public CheckFreeNumber(int numOfBox) {
        this.numOfBoxes = numOfBox;
    }

    public int getFreeBoxes() {
        if (this.numOfBoxes > 10) {
            return this.numOfBoxes - 10;
        } else {
            return 0;
        }
    }
   
    
}
