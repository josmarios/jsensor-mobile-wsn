package projects.MobileWSN.sink;

import java.util.LinkedList;

import jsensor.nodes.Node;
import jsensor.nodes.messages.Inbox;
import jsensor.nodes.messages.Message;
import jsensor.runtime.Jsensor;
import projects.MobileWSN.FloodingMessage;

public class SinkNode extends Node {

	public LinkedList<Long> messagesIDs;
	
	@Override
	public void handleMessages(Inbox inbox) {	
		while (inbox.hasMoreMessages()) {
			System.out.println("Message received - Sink");
			Message message = inbox.getNextMessage();

			if (message instanceof FloodingMessage) {
				FloodingMessage floodingMessage = (FloodingMessage) message;

				if (this.messagesIDs.contains(floodingMessage.getID())) {
					continue;
				}

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
				}
			}
		}
		
	}

	@Override
	public void onCreation() {
		// TODO Auto-generated method stub
		
	}

}
