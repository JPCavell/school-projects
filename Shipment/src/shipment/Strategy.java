package shipment;

/* Name: Jacob Cavell
 * Course: CSC 285
 * Project: Shipment
 * File Name: Strategy.java
 */

 /*
 * This program is the driver class
 */
public class Strategy {

    /*
    * This methodis the main method that creates each instance of a carrier
    * Then, it will call the writetoFile method for each shipment
     */
    public static void main(String[] args) {

        Shipment upsShipment = new UPS();
        Shipment fedexShipment = new FedEx();
        Shipment dhlShipment = new DHL();
        Shipment bigBobsShipment = new BigBobs();

        upsShipment.writetoFile();
        fedexShipment.writetoFile();
        dhlShipment.writetoFile();
        bigBobsShipment.writetoFile();
    }
}
