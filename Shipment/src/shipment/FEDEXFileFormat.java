package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: FEDEXFileFormat.java
 */

 /*
 * This program represents the concrete strategy for FEDEX
 * It will implement interface writeCarrierFile
 */
class FedExFileFormat implements writeCarrierFile {

    //This method prints out how the file should be formatted according to the carrier
    @Override
    public void writetoFile() {
        System.out.println("Write a file properly formatted for FedEx");
    }
}
