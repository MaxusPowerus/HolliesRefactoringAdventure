package utilities;

import entities.NPC;

public class Challenge {

	private NPC npc;
	private Container container;

	public Challenge(NPC npc, Container container) {
		this.npc = npc;
		this.container = container;
	}

	public NPC getNpc() {
		return npc;
	}

	public Container getContainer() {
		return container;
	}

}
