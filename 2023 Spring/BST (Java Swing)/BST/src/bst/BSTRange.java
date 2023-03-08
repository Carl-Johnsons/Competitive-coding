/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Nguyen Le Tai Duc CE170499
 */
public class BSTRange {

    private int leftIndex;
    private int rightIndex;

    /**
     * This constructor will serve the balancing purpose
     * @param leftIndex
     * @param rightIndex
     */
    public BSTRange(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    /**
     *
     * @return
     */
    public int getLeftIndex() {
        return leftIndex;
    }

    /**
     *
     * @param leftIndex
     */
    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    /**
     *
     * @return
     */
    public int getRightIndex() {
        return rightIndex;
    }

    /**
     *
     * @param rightIndex
     */
    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }
    
}
