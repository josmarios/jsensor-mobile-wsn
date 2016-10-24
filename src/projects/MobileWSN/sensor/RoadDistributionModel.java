package projects.MobileWSN.sensor;

import jsensor.nodes.Node;
import jsensor.nodes.models.DistributionModelNode;
import jsensor.utils.Configuration;
import jsensor.utils.Position;

public class RoadDistributionModel extends DistributionModelNode {

	@Override
	public Position getPosition(Node arg0) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Position(1, arg0.getRandom().nextInt( Configuration.dimY));
	}

}
