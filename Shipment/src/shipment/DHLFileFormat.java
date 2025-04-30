package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: DHLFileFormat.java
 */

 /*
 * This program represents the concrete strategy for DHL
 * It will implement interface writeCarrierFile
 */
class DHLFileFormat implements writeCarrierFile {

    //This method prints out how the file should be formatted according to the carrier
    @Override
    public void writetoFile() {
        System.out.println("Write a file properly formatted for DHL");
    }
}
