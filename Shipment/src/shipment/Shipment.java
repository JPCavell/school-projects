package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: Shipment.java
 */

 /*
 * This program is the abstract object (Basically a shipment that does not have a specified carrier yet)
 */
public abstract class Shipment {

    protected writeCarrierFile fileFormatStrategy;

    public Shipment(writeCarrierFile fileFormatStrategy) {
        this.fileFormatStrategy = fileFormatStrategy;
    }

    /*
     * This writetoFile method delegates the write-to-file operation to the strategy object
     */
    public void writetoFile() {
        fileFormatStrategy.writetoFile();
    }
}
