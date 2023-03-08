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
public class NodeData {

    private int data;
    private int count;

    /**
     * This constructor will serve the balancing purpose
     *
     * @param data
     * @param count
     */
    public NodeData(int data, int count) {
        this.data = data;
        this.count = count;
    }

    /**
     *
     */
    public NodeData() {
    }

    /**
     *
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

}
