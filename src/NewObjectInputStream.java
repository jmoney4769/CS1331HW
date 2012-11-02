import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class NewObjectInputStream extends ObjectInputStream implements
		Serializable {

	public NewObjectInputStream(InputStream in) throws IOException {
		super(in);
	}

}
