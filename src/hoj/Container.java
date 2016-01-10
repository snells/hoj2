package hoj;


public class Container extends ContainerData {
	
	public Container(int i, String t, long ms) {
		index = i;
		type = t;
		reserved = false;
		user = "";
		stuff = 0;
		inUse = false;
		maxStuff = ms;
	}

public boolean reserve(String name) {
	if(reserved)
		return false;
	else {
		reserved = true;
		user = name;
		return true;
	}
}

public boolean isReserved() {
	return reserved;
}

public boolean connect(boolean t) {
	if(inUse)
		return false;
	
}



public String getUser() {
	return user;
}


public long roomLeft() {
	return maxStuff - stuff;
}
public long getStuff() {
	return stuff;
}

public boolean startTransfer(boolean f) {
	if(inUse)
		return false;
	else {
		inUse = true;
		fill = f;
		return true;
	}
}
public void transfer(long c) {
	if(fill)
		stuff += c;
	else
		stuff -= c;
}

public boolean validateUser(String n) {
	return (user != null && n.equals(user)) ? true : false;
}

public boolean stopTransfer() {
	if(!inUse)
		return false;
	else {
		inUse = false;
		return true;
	}
}
public void free() {
	reserved = false;
	user = "";
	inUse = false;
}
	
	
}