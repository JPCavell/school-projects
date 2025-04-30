package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: BIGBOBS.java
 */

 /*
 * This program represents a shipment carried by BIGBOBS
 * It extends shipment and uses its own strategy for the writeToFile method
 */
class BigBobs extends Shipment {

    // Constructor method
    public BigBobs() {
        super(new BigBobsFileFormat());
    }
}
