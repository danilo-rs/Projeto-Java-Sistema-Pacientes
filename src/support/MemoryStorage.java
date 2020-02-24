package support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import support.Entity;

/**
 * A generic storage.
 * 
 * @author Mauricio Rodrigues <mmauricio.vsr[at]gmail.com>
 */
public class MemoryStorage {
	
	/**
	 * The Entity storage.
	 */
	private static Map<String, ArrayList<Entity>> storage;
	
	/**
	 * Query all entities from a key.
	 * 
	 * @param key
	 * @return
	 */
	public static ArrayList<Entity> select(String key) {
		if (storage == null) {
			return null;
		}
		
		return storage.get(key);
	}
	
	/**
	 * Store a Entity.
	 * 
	 * @param key
	 * @param entity
	 */
	public static boolean store(String key, Entity entity) {
		
		if (storage == null) {
			storage = new HashMap<>();
		}
		
		ArrayList<Entity> entities = storage.get(key);
		
		if (entities == null) {
			entities = new ArrayList<>();
		}
		
		entity.setId(entities.size() + 1);
		entities.add(entity);
		
		storage.put(key, entities);
		
		return true;
	}
	
	/**
	 * Find a Entity by id.
	 * 
	 * @param location
	 * @param id
	 * @return
	 */
	public static Entity find(String key, int id) {
		if (storage == null || storage.size() == 0) {
			return null;
		}
		
		ArrayList<Entity> entities = storage.get(key);
		
		if (entities == null) {
			return null;
		}
		
		for(Entity e : entities) {
			if (e.getId() == id) {
				return e;
			}
		}
		
		return null;
	}
	
	/**
	 * Update a Entity.
	 * 
	 * @param key
	 * @param entity
	 * @return
	 */
	public static boolean update(String key, Entity entity) {
		
		if (count(key) == 0) {
			return false; // or throw a new exception...
		}
		
		ArrayList<Entity> entities = storage.get(key);
		ArrayList<Entity> newEntities = new ArrayList<>();
		
		for (Entity e : entities) {
			Entity newEntity = e;
			
			if (e.getId() == entity.getId()) {
				newEntity = entity;
			}
			
			newEntities.add(newEntity);
		}
		
		storage.put(key, newEntities);
		
		return true;
	}
	
	/**
	 * Delete a Entity by id.
	 * 
	 * @param location
	 * @param id
	 * @return
	 */
	public static boolean delete(String key, int id) {
		if (storage == null || storage.size() == 0) {
			return false;
		}
		
		ArrayList<Entity> entities = storage.get(key);
		ArrayList<Entity> newEntities = new ArrayList<>();
		Map<String, ArrayList<Entity>> newStorage = new HashMap<>();
		
		for(Entity entity : entities) {
			if (entity.getId() != id) {
				newEntities.add(entity);
			}
		}
		
		newStorage.put(key, newEntities);
		
		storage = newStorage;
		
		return true;
	}
	
	/**
	 * Count the number of Entities.
	 * 
	 * @param location
	 * @return
	 */
	public static int count(String key) {
		return storage.get(key).size();
	}
}