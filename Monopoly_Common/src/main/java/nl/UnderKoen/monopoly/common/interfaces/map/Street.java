package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Street extends Serializable {
    int getId() throws RemoteException;

    void setId(int id) throws RemoteException;

    StreetType getStreetType() throws RemoteException;
}
