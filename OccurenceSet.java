import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OccurenceSet<T> implements Set<T> {

	HashMap<T, Integer> _map;

	public OccurenceSet() {
		_map = new HashMap<>();
	}

	public ArrayList<T> compareKeys() {
		ArrayList<T> entriesList = new ArrayList<>(_map.keySet());

		Collections.sort(entriesList, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return _map.get(o1) - _map.get(o2);
			}
		});
		return entriesList;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.toArray());
	}

	@Override
	public boolean add(T e) {
		if (_map.containsKey(e)) {
			_map.put(e, _map.get(e) + 1);
			return false;
		} else {
			_map.put(e, 1);
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean bool = false;
		for (T thing : c) {
			add(thing);
			if (add(thing) == false) {
				bool = true;
			}
		}
		return bool;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_map.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		boolean bool = false;
		if (_map.containsKey(o) == true) {
			bool = true;
		}
		return bool;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean bool = true;
		for (Object thing : c) {
			if (_map.containsKey(thing) == false) {
				bool = false;
			}
		}
		return bool;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return _map.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		ArrayList<T> list = compareKeys();
		return list.iterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if (_map.containsKey(o)) {
			_map.remove(o);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean bool = false;
		for (Object thing : c) {
			_map.remove(thing);
			if (remove(thing) == false) {
				bool = true;
			}
		}
		return bool;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean bool = false;
		for (Object i : c) {
			if (((c.contains(i) == true) && (_map.containsKey(i) == false)) == false) {
				_map.remove(i);
				bool = true;
			}
		}
		return bool;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return _map.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		ArrayList<T> tList = compareKeys();
		Object[] objectList = new Object[this.size()];
		for (int i = 0; i < tList.size(); i++) {
			objectList[i] = tList.get(i);
		}
		return objectList;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		ArrayList<T> tList = (ArrayList<T>) compareKeys();
		for (int i = 0; i < tList.size(); i++) {
			a[i] = tList.get(i);
		}
		return a;
	}
}
