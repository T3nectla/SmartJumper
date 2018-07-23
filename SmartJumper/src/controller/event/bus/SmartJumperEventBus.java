package controller.event.bus;

import com.google.common.eventbus.EventBus;

import controller.event.listener.entitylistener.EntityListener;
import controller.event.listener.playerlistener.PlayerListener;

public class SmartJumperEventBus extends EventBus {
	
	private static final SmartJumperEventBus smartJumperEventBus = new SmartJumperEventBus();
	private SmartJumperEventBus() {}
	public static SmartJumperEventBus getInstance() {
		return smartJumperEventBus;
	}
	
	static {
		smartJumperEventBus.register(new EntityListener());
		smartJumperEventBus.register(new PlayerListener());
	}
}