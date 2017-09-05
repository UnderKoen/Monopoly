package nl.UnderKoen.monopoly.common.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Under_Koen on 12-06-17.
 */
public interface Updatable<T> extends Remote {
    void setModel(T model) throws RemoteException;

    void close(String key) throws RemoteException;

    void popup(String key) throws RemoteException;

    default void testConnection() throws RemoteException {
    }

    void warn(Exception ex) throws RemoteException;
}
