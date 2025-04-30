package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: DHL.java
 */

 /*
 * This program represents a shipment carried by DHL
 * It extends shipment and uses its own strategy for the writeToFile method
 */
class DHL extends Shipment {

    // Constructor method
    public DHL() {
        super(new DHLFileFormat());
    }
}
