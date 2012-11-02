import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class NewObjectOutputStream extends ObjectOutputStream implements
		Serializable {

	public NewObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

}
