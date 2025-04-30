package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: BIGBOBSFileFormat.java
 */

 /*
 * This program represents the concrete strategy for BIGBOBS
 * It will implement interface writeCarrierFile
 */
class BigBobsFileFormat implements writeCarrierFile {

    //This method prints out how the file should be formatted according to the carrier
    @Override
    public void writetoFile() {
        System.out.println("Write a generic csv file for a small local delivery co.");
    }
}
