package hoj;


public class Container extends ContainerData {

	private static final long serialVersionUID = 3305322993505776743L;


	public Container(int i, String t, long ms) {
		index = i;
		type = t;
		reserved = false;
		user = "";
		stuff = 0;
		inUse = false;
		maxStuff = ms;
		procesState = "";
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


// true fill, false give
public boolean connect(boolean t) {
	if(inUse)
		return false;
	fill = t;
	return true;
	
}

public boolean full() {
	return (stuff >= maxStuff);
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
		inUse = false;
		return true;
}


public ContainerData toData() {
	return new ContainerData(
			index, type, stuff, maxStuff,
			reserved, user, inUse, fill, procesState);
	//return (ContainerData)this;
}


public boolean free(String name) {
	if(inUse)
		return false;
	if(!name.equals(user))
		return false;
	
	reserved = false;
	user = "";
	inUse = false;
	return true;
}

	
	
}