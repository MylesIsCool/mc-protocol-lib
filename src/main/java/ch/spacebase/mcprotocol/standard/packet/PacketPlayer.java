package ch.spacebase.mcprotocol.standard.packet;

import ch.spacebase.mcprotocol.event.PacketVisitor;
import ch.spacebase.mcprotocol.net.io.NetInput;
import ch.spacebase.mcprotocol.net.io.NetOutput;
import java.io.IOException;

import ch.spacebase.mcprotocol.net.Client;
import ch.spacebase.mcprotocol.net.ServerConnection;
import ch.spacebase.mcprotocol.packet.Packet;

public class PacketPlayer extends Packet {

	public boolean grounded;

	public PacketPlayer() {
	}

	public PacketPlayer(boolean grounded) {
		this.grounded = grounded;
	}

	@Override
	public void read(NetInput in) throws IOException {
		this.grounded = in.readBoolean();
	}

	@Override
	public void write(NetOutput out) throws IOException {
		out.writeBoolean(this.grounded);
	}

	@Override
	public void handleClient(Client conn) {
	}

	@Override
	public void handleServer(ServerConnection conn) {
	}

	@Override
	public int getId() {
		return 10;
	}

	@Override
	public void accept(PacketVisitor visitor) {
		visitor.visit(this);
	}

}
