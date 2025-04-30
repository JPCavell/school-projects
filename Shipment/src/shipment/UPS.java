package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: UPS.java
 */

 /*
 * This program represents a shipment carried by UPS
 * It extends shipment and uses its own strategy for the writeToFile method
 */
class UPS extends Shipment {

    // Constructor method
    public UPS() {
        super(new UPSFileFormat());
    }
}
