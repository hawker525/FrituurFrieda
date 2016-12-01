package be.vdab.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import be.vdab.entities.*;

public class SausDAO {
	private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();
	private static final Random r = new Random();
	
	static {
		SAUZEN.put(1L, new Saus(1, "cocktail", Arrays.asList("cocktail", "test")));
		SAUZEN.put(2L, new Saus(2, "mayonaise", Arrays.asList("mayonaise", "test")));
		SAUZEN.put(3L, new Saus(3, "mosterd", Arrays.asList("mosterd", "test")));
		SAUZEN.put(4L, new Saus(4, "tartare", Arrays.asList("tartare")));
		SAUZEN.put(5L, new Saus(5, "vinaigrette", Arrays.asList("vinaigrette", "test")));
	}
	
	public List<Saus> findAll(){
		return SAUZEN.values().stream().collect(Collectors.toList());
	}
	
	public List<Saus> findSausByIngredient(String ingredient){
		return SAUZEN.values().stream()
				.filter(s -> s.getIngredienten().contains(ingredient))
				.collect(Collectors.toList());
	}
	
	public Saus removeSausById(long id) {
		return SAUZEN.remove(id);
	}
	
	public Saus getRandomSaus(){
		Object[] sauzen = SAUZEN.values().toArray();
		return (Saus) sauzen[r.nextInt(sauzen.length)]	;
	}
}
