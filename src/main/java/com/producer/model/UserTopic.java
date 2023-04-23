package com.producer.model;

public class UserTopic {

	private String name;
	private int partitions;
	private int replicas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPartitions() {
		return partitions;
	}

	public void setPartitions(int partitions) {
		this.partitions = partitions;
	}

	public int getReplicas() {
		return replicas;
	}

	public void setReplicas(int replicas) {
		this.replicas = replicas;
	}

	public UserTopic() {
		super();
	}

	public UserTopic(String name, int partitions, int replicas) {
		super();
		this.name = name;
		this.partitions = partitions;
		this.replicas = replicas;
	}

}
