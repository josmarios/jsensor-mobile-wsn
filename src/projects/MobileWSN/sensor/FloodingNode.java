package projects.MobileWSN.sensor;

import java.util.LinkedList;

import jsensor.runtime.Jsensor;
import jsensor.utils.Configuration;
import projects.MobileWSN.FloodingMessage;
import projects.MobileWSN.FloodingTimer;
import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;

/**
 *
 * @author danniel & Matheus
 */
public class FloodingNode extends Node {
	public LinkedList<Long> messagesIDs;

	@Override
	public void handleMessages(Inbox inbox) {
		
		
		while (inbox.hasMoreMessages()) {
			

			Message message = inbox.getNextMessage();

			if (message instanceof FloodingMessage) {
				FloodingMessage floodingMessage = (FloodingMessage) message;
//				System.out.println("Message Received -" + floodingMessage.getHops());
				//if (this.messagesIDs.contains(floodingMessage.getID())) {
					//continue;
				//}

				this.messagesIDs.add(floodingMessage.getID());

				if (floodingMessage.getDestination().equals(this)) {
					System.out.println(this);
					Jsensor.log("time: " + Jsensor.currentTime + "\t sensorID: " + this.ID + "\t receivedFrom: "
							+ floodingMessage.getSender().getID() + "\t hops: " + floodingMessage.getHops() + "\t msg: "
							+ floodingMessage.getMsg().concat(this.ID + ""));

					System.out.println("time: " + Jsensor.currentTime + "\t sensorID: " + this.ID + "\t receivedFrom: "
							+ floodingMessage.getSender().getID() + "\t hops: " + floodingMessage.getHops() + "\t msg: "
							+ floodingMessage.getMsg().concat(this.ID + ""));
				} else {
					
					int n = 999999;
					int cont = 0;
					for (int i = 1; i <= n; i++) {
						if (n % i == 0)
							cont = cont + 1;
					}

					if (cont > 0) {
						
						floodingMessage.setMsg(floodingMessage.getMsg().concat(this.ID + " - "));
						this.multicast(message);
					}
					//System.out.println(this.getID()+">>>"+this.getPosition().toString());
					
				}
			}
		}
	}

	@Override
	public void onCreation() {
		// initializes the list of messages received by the node.
		this.messagesIDs = new LinkedList<Long>();

		// sends the first messages if is one of the selected nodes
		if (this.ID < 10) {
			int time = 10 + this.ID * 10;
			FloodingTimer ft = new FloodingTimer();
			ft.startRelative(time, this);
		}
		
		SensorMobilityModel ct = new SensorMobilityModel();        
         ct.start(this, this.getRandom().nextInt(100), Configuration.numberOfRounds, 10);
	}
}
