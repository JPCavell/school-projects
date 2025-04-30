package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: FEDEX.java
 */

 /*
 * This program represents a shipment carried by FEDEX
 * It extends shipment and uses its own strategy for the writeToFile method
 */
class FedEx extends Shipment {

    //Constructor method
    public FedEx() {
        super(new FedExFileFormat());
    }
}
