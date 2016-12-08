package org.springframework.social.instagram.api;

import java.io.Serializable;

public class Relationship implements Serializable {

	private OutgoingStatus outgoingStatus;
	private IncomingStatus incomingStatus;

	public Relationship(OutgoingStatus outgoingStatus, IncomingStatus incomingStatus) {
		this.outgoingStatus = outgoingStatus;
		this.incomingStatus = incomingStatus;
	}

	public OutgoingStatus getOutgoingStatus() {
		return outgoingStatus;
	}

	public IncomingStatus getIncomingStatus() {
		return incomingStatus;
	}

	public static enum OutgoingStatus {
		FOLLOWS,
		REQUESTED,
		NONE
	}

	public static enum IncomingStatus {
		FOLLOWED_BY,
		REQUESTED_BY,
		BLOCKED_BY_YOU,
		NONE
	}
}
