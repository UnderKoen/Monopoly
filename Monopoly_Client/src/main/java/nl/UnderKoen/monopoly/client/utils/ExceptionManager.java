package nl.UnderKoen.monopoly.client.utils;

import nl.UnderKoen.monopoly.client.Client;
import nl.UnderKoen.monopoly.client.view.ExceptionDialog;
import nl.UnderKoen.monopoly.client.view.scenes.SceneLogin;

import java.rmi.*;

/**
 * Created by Under_Koen on 12-06-17.
 */
public class ExceptionManager {
    public static void handleRemoteException(RemoteException rex) {
        if (rex instanceof ConnectException || rex instanceof ConnectIOException) {
            ExceptionDialog.warning("error.connect.notfound");
        } else if (rex instanceof MarshalException || rex instanceof NoSuchObjectException
                || rex instanceof StubNotFoundException || rex instanceof AccessException) {
            ExceptionDialog.warning("error.version.diffrence");
        } else if (rex instanceof ServerError || rex instanceof ServerException || rex instanceof UnexpectedException) {
            ExceptionDialog.warning("error.server.error");
        } else {
            ExceptionDialog.warning("error.remote.unkown");
        }
        rex.printStackTrace();
        Client.setScene(new SceneLogin());
    }
}