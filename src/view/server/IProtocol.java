package view.server;
import java.io.InputStream;
import java.io.OutputStream;

public interface IProtocol {

    public void execute( IContext aContext , InputStream anInputStream , OutputStream anOutputStream, ServeurTCP myServer);

}